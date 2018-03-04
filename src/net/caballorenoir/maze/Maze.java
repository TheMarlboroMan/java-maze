package net.caballorenoir.maze;

import java.util.EnumSet;

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

	public void carve_exit(Coords _c, Tools.DirFlag _dir) throws Exception {
		this.get_cell(_c.get_neighbour(_dir)).carve(Tools.opposite_direction(_dir));
		this.get_cell(_c).carve(_dir);
	}

	private void initialize_cells() {
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {

				EnumSet<Tools.DirFlag> limits=EnumSet.noneOf(Tools.DirFlag.class);
				if(0==x) 		limits.add(Tools.DirFlag.left);		//No else, in case we want a 1x1 maze XD.
				if(x==this.width-1) 	limits.add(Tools.DirFlag.right);
				if(0==y) 		limits.add(Tools.DirFlag.up);
				if(y==this.height-1) 	limits.add(Tools.DirFlag.down);
				cells[x][y]=new Cell(limits);
			}
		}
	}

}
