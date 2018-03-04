package net.caballorenoir.maze;

public class Coords {

	public int x;
	public int y;

	public Coords(Coords _c) {
		x=_c.x;
		y=_c.y;
	}

	public Coords(int _x, int _y) {
		x=_x;
		y=_y;
	}

	public void move_to(int _x, int _y) {
		x=_x;
		y=_y;
	}

	public Coords get_neighbour(Tools.DirFlag _dir) throws Exception {
		Coords res=new Coords(this);
		res.move(_dir);
		return res;
	}

	public void move(Tools.DirFlag _dir) {
		if(_dir==Tools.DirFlag.up)	{--y;}
		if(_dir==Tools.DirFlag.right) 	{++x;}
		if(_dir==Tools.DirFlag.down)	{++y;}
		if(_dir==Tools.DirFlag.left)	{--x;}
	}
}
