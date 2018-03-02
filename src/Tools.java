import java.util.concurrent.ThreadLocalRandom;
import java.util.EnumSet;

public class Tools {

	public enum DirFlag {up, right, down, left};

	public static DirFlag opposite_direction(DirFlag _dir) {
		if(_dir==DirFlag.up)	return Tools.DirFlag.down;
		else if(_dir==DirFlag.right)	return Tools.DirFlag.left;
		else if(_dir==DirFlag.down)	return Tools.DirFlag.up;
		else return Tools.DirFlag.right;
	}

	//TODO Hmm...
	public static DirFlag get_random_direction_from(EnumSet<DirFlag> _dir) {
		//Fuck the world XD!.
		while(true) {
			int bit=ThreadLocalRandom.current().nextInt(0, 4); //From 0 to 3.
			switch(bit) {
				case 0: if( _dir.contains(DirFlag.up)) return DirFlag.up; break;
				case 1: if( _dir.contains(DirFlag.right)) return DirFlag.right; break;
				case 2: if( _dir.contains(DirFlag.down)) return DirFlag.down; break;
				case 3: if( _dir.contains(DirFlag.left)) return DirFlag.left; break;
			}
		}
	}
}
