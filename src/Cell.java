import java.util.EnumSet;

public class Cell {

	private EnumSet<Tools.DirFlag> exits=EnumSet.noneOf(Tools.DirFlag.class);
	private EnumSet<Tools.DirFlag> limits=EnumSet.noneOf(Tools.DirFlag.class);

	public Cell(EnumSet<Tools.DirFlag> _l) {
		limits=_l;
	}

	public EnumSet<Tools.DirFlag> get_exits() {
		return exits;
	}

	public EnumSet<Tools.DirFlag> get_limits() {
		return limits;
	}

	public void carve(Tools.DirFlag _pos) {
		exits.add(_pos);
	}

	public boolean is_limit(Tools.DirFlag _pos) {
		return limits.contains(_pos);
	}

	public boolean is_open(Tools.DirFlag _pos) {
		return exits.contains(_pos);
	}

	public EnumSet<Tools.DirFlag> get_blocked_directions(){
		EnumSet<Tools.DirFlag> res=EnumSet.complementOf(exits);
		res.addAll(limits);
		return res;
	}

	public EnumSet<Tools.DirFlag> get_free_directions() throws Exception {
		EnumSet<Tools.DirFlag> res=EnumSet.copyOf(exits);
		res.removeAll(limits);
		return res;
	}
}
