package net.caballorenoir.maze;

public class ConsoleDisplay extends BaseCharacterDisplay implements Display {

	public void draw(Maze _maze) throws Exception {
		Coords coords=new Coords(0,0);

		for(int y=0; y<_maze.get_height(); y++) {
			StringBuilder sb=new StringBuilder();
			for(int x=0; x<_maze.get_width(); x++) {
				coords.x=x;
				coords.y=y;
				sb.append(from_cell(_maze.get_cell(coords)));
			}
			System.out.println(sb.toString());
		}
	}
}
