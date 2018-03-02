import java.util.EnumSet;

public class Display {

	public Display() {

	}

	public char from_direction(EnumSet<Tools.DirFlag> _dir) throws Exception {
		
		if(_dir.isEmpty())	return '.';
		if(_dir.equals(EnumSet.of(Tools.DirFlag.up)))	return get(244);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.right)))	return get(168);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.down)))	return get(243);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.left)))	return get(169);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.up, Tools.DirFlag.right)))	return get(191);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.up, Tools.DirFlag.down)))	return get(178);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.up, Tools.DirFlag.left)))	return get(216);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.right, Tools.DirFlag.down)))	return get(217);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.right, Tools.DirFlag.left)))	return get(195);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.down, Tools.DirFlag.left)))	return get(190);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.up, Tools.DirFlag.right, Tools.DirFlag.down)))	return get(194);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.up, Tools.DirFlag.right, Tools.DirFlag.left)))	return get(192);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.up, Tools.DirFlag.down, Tools.DirFlag.left)))	return get(179);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.right, Tools.DirFlag.down, Tools.DirFlag.left)))	return get(193);
		if(_dir.equals(EnumSet.of(Tools.DirFlag.up, Tools.DirFlag.right, Tools.DirFlag.down, Tools.DirFlag.left)))	return get(196);
//		if(_dir.containsAll(EnumSet.allOf(Tools.DirFlag)))	return get(196);

		throw new Exception("Unknown dir value");
	}

	private char from_cell(Cell _c) throws Exception {
		return from_direction(_c.get_free_directions());
	}

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

	//https://stackoverflow.com/questions/22273046/how-to-print-the-extended-ascii-code-in-java-from-integer-value
	private static final char[] EXTENDED = { 0x00C7, 0x00FC, 0x00E9, 0x00E2,
		0x00E4, 0x00E0, 0x00E5, 0x00E7, 0x00EA, 0x00EB, 0x00E8, 0x00EF,
		0x00EE, 0x00EC, 0x00C4, 0x00C5, 0x00C9, 0x00E6, 0x00C6, 0x00F4,
		0x00F6, 0x00F2, 0x00FB, 0x00F9, 0x00FF, 0x00D6, 0x00DC, 0x00A2,
		0x00A3, 0x00A5, 0x20A7, 0x0192, 0x00E1, 0x00ED, 0x00F3, 0x00FA,
		0x00F1, 0x00D1, 0x00AA, 0x00BA, 0x00BF, 0x2310, 0x00AC, 0x00BD,
		0x00BC, 0x00A1, 0x00AB, 0x00BB, 0x2591, 0x2592, 0x2593, 0x2502,
		0x2524, 0x2561, 0x2562, 0x2556, 0x2555, 0x2563, 0x2551, 0x2557,
		0x255D, 0x255C, 0x255B, 0x2510, 0x2514, 0x2534, 0x252C, 0x251C,
		0x2500, 0x253C, 0x255E, 0x255F, 0x255A, 0x2554, 0x2569, 0x2566,
		0x2560, 0x2550, 0x256C, 0x2567, 0x2568, 0x2564, 0x2565, 0x2559,
		0x2558, 0x2552, 0x2553, 0x256B, 0x256A, 0x2518, 0x250C, 0x2588,
		0x2584, 0x258C, 0x2590, 0x2580, 0x03B1, 0x00DF, 0x0393, 0x03C0,
		0x03A3, 0x03C3, 0x00B5, 0x03C4, 0x03A6, 0x0398, 0x03A9, 0x03B4,
		0x221E, 0x03C6, 0x03B5, 0x2229, 0x2261, 0x00B1, 0x2265, 0x2264,
		0x2320, 0x2321, 0x00F7, 0x2248, 0x00B0, 0x2219, 0x00B7, 0x221A,
		0x207F, 0x00B2, 0x25A0, 0x00A0 };

	private static final char get(int _code) {
		if (_code >= 0x80 && _code <= 0xFF) {
			return EXTENDED[_code - 0x7F];
		}
		return (char)_code;
	}


}
