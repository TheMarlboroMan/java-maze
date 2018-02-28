public class Cell {

	private int exits;
	private int limits;

	public Cell(int _l) {
		exits=Tools.none;
		limits=_l;
	}

	public int get_exits() {
		return exits;
	}

	public int get_limits() {
		return limits;
	}

	public void carve(int _pos) {
		exits|=_pos;
	}

	public boolean is_limit(int _pos) {
		return (limits & _pos)!=0;
	}

	public boolean is_open(int _pos) {
		return (exits & _pos)!=0;
	}

	public int get_blocked_directions(){
		int res=exits^(Tools.up|Tools.right|Tools.down|Tools.left);
		return res|limits;
	}

	public int get_free_directions() throws Exception{
		return exits & (~limits);
	}
}
