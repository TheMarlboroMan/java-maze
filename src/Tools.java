import java.util.concurrent.ThreadLocalRandom;

public class Tools {

	public static final int none=0;
	public static final int up=1;
	public static final int right=2;
	public static final int down=4;
	public static final int left=8;

	public static int opposite_direction(int _dir) throws Exception {
		switch(_dir) {
			case Tools.none: 	return Tools.none;
			case Tools.up:		return Tools.down;
			case Tools.right:	return Tools.left;
			case Tools.down:	return Tools.up;
			case Tools.left:	return Tools.right;
			default: throw new Exception("Unable to solve opposite_direction "+_dir);
		}
	}

	//TODO: There must be a nicer way... right?
	public static int get_random_direction_from(int _dir) {
		//Fuck the world XD!.
		while(true) {
			int bit=ThreadLocalRandom.current().nextInt(0, 4); //From 0 to 3.
			switch(bit) {
				case 0: if( (_dir & Tools.up) != 0) return Tools.up; break;
				case 1: if( (_dir & Tools.right) != 0) return Tools.right; break;
				case 2: if( (_dir & Tools.down) != 0) return Tools.down; break;
				case 3: if( (_dir & Tools.left) != 0) return Tools.left; break;
			}
		}
	}
}
