import java.util.ArrayList;

public class Generator {

	//Fuck you fuck you fuck you fuck you fuck you fuck you ... Integer.
	private ArrayList<Integer> 	visited;
	private ArrayList<Coords>	stack;

	public Generator() {
		visited=new ArrayList<Integer>();
		stack=new ArrayList<Coords>();
	}

	public void generate(Maze _maze) throws Exception {
		//Choose first cell...
		Coords coords=new Coords(0,0);
		int direction=Tools.none;

		stack.add(new Coords(coords));
		visited.add(calculate_coords_hash(coords, _maze));

		do{
			direction=choose_random_direction(coords, _maze);
			if(Tools.none==direction) {
				coords=new Coords(stack.remove(stack.size()-1));
			}
			else { 
				_maze.carve_exit(coords, direction);
				coords.move(direction);
				stack.add(new Coords(coords));
				visited.add(calculate_coords_hash(coords, _maze));
			}
		}while(stack.size()!=0);
	}

	private int choose_random_direction(Coords _coords, Maze _maze) throws Exception {

		int directions=_maze.get_cell(_coords).get_blocked_directions();
		while(directions!=Tools.none) {
			
			int res=Tools.get_random_direction_from(directions);
			directions&=~res;
			if(!check_free_direction(_coords, _maze, res)) continue;
			return res;
		}
		return Tools.none;
	}

	private boolean check_free_direction(Coords _coords, Maze _maze, int _dir) throws Exception {
		Cell cell=_maze.get_cell(_coords);
		if(cell.is_open(_dir)) {
			return false;	//If open, we already visited.
		}
		if(cell.is_limit(_dir)) {
			return false;	//If hard limits are found, we can't carve.
		}
		if(this.visited.contains(this.calculate_coords_hash(_coords.get_neighbour(_dir), _maze))) {
			return false;
		}
		return true;
	}

	private int calculate_coords_hash(Coords _c, Maze _maze) {
		return (_c.y*_maze.get_width()) + _c.x;
	}
}
