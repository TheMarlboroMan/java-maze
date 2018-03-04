package net.caballorenoir.maze;

public class main {

	public static void main(String[] args) {

		if(args.length != 2) {
			System.out.println("use: main width height ");
		}
		else {
			try {
				Maze maze=new Maze(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
				Generator gen=new Generator();
				gen.generate(maze);
				Display display=new Display();
				display.draw(maze);
			}
			catch(Exception e) {
				System.out.println("Something went wrong, probably your fault: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
