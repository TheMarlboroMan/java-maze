public class Maze {

	private int		width;
	private int		height;
	private Cell[][]	cells;

	public Maze(int _w, int _h) {
		width=_w;
		height=_h;
		cells=new Cell[width][height];
		initialize_cells();
	}

	public int get_width() {
		return width;
	}

	public int get_height() {
		return height;
	}

	public Cell get_cell(Coords _c) {
		return cells[_c.x][_c.y];
	}

	public void carve_exit(Coords _c, int _dir) throws Exception {
		this.get_cell(_c.get_neighbour(_dir)).carve(Tools.opposite_direction(_dir));
		this.get_cell(_c).carve(_dir);
	}

	private void initialize_cells() {
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {

				int limits=Tools.none;
				if(0==x) limits|=Tools.left;		//No else, in case we want a 1x1 maze XD.
				if(x==this.width-1) limits|=Tools.right;
				if(0==y) limits|=Tools.up;
				if(y==this.height-1) limits|=Tools.down;

				cells[x][y]=new Cell(limits);
			}
		}
	}

}
