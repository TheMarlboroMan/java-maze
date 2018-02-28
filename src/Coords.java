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

	public Coords get_neighbour(int _dir) throws Exception {
		Coords res=new Coords(this);
		res.move(_dir);
		return res;
	}

	public void move(int _dir) throws Exception {
		switch(_dir) {
			case Tools.up: 		--y; break;
			case Tools.right:	++x; break;
			case Tools.down:	++y; break;
			case Tools.left:	--x; break;
			default: throw new Exception("Unknown exit type "+_dir);
		}
	}
}
