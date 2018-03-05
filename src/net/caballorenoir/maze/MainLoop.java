package net.caballorenoir.maze;

import java.util.Scanner;

class MainLoop {

	private static final String OUTCONSOLE="console";
	private static final String OUTFILE="file";
	private static final String OUTGUI="gui";
	private static final String EXIT="exit";

	public void run() {
		//Perhaps I could use the Console, instead of an scanner.
		Scanner s=null;
		try {
			s=new Scanner(System.in);
		}
		catch(Exception e) {
			System.out.print("Unable to initialise user input");
			e.printStackTrace();
			return;
		}

		while(true) {
			System.out.printf(">>>width height [file|console|gui] (blank to finish)%n");
			String line=s.nextLine();
			if(line.length()==0) {
				System.out.println("Exiting...");
				break;
			}

			try(Scanner ls=new Scanner(line)) {
				Maze maze=new Maze(ls.nextInt(), ls.nextInt());
				Generator gen=new Generator();
				gen.generate(maze);
				Display display=get_display(ls.next());
				display.draw(maze);
			}
			catch(Exception e) {
				System.out.println("Something went wrong, probably your fault: "+e.getMessage());
				e.printStackTrace();
			}
		}
		s.close();
	}

	private Display get_display(String type) throws Exception {

		if(type.equals(OUTCONSOLE)) {
			return new ConsoleDisplay();
		}
		else if(type.equals(OUTFILE)) {
			return new FileDisplay();
		}
		else if(type.equals(OUTGUI)) {
			return new GUIDisplay();
		}

		throw new Exception("No valid display specified");
	}
}
