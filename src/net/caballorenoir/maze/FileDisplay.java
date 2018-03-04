package net.caballorenoir.maze;

import java.io.FileWriter;

class FileDisplay extends BaseCharacterDisplay implements Display {

	public void draw(Maze _maze) throws Exception {
		//Could also use a PrintWriter...
		FileWriter out=null;
		Coords coords=new Coords(0,0);

		try {
			out=new FileWriter("maze.txt");
			for(int y=0; y<_maze.get_height(); y++) {
				for(int x=0; x<_maze.get_width(); x++) {
					coords.x=x;
					coords.y=y;
					out.write(from_cell(_maze.get_cell(coords)));
				}
				out.write(System.lineSeparator());
			}
		}
		finally {
			if(null!=out) {
				out.close();
			}
		}
	}

}
