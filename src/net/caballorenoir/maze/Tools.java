package net.caballorenoir.maze;

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

	public static DirFlag get_random_direction_from(EnumSet<DirFlag> _dir) {
		Object[] list=_dir.toArray();
		return (DirFlag)list[ThreadLocalRandom.current().nextInt(0, list.length)];
	}
}
