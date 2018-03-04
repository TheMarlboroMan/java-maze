package net.caballorenoir.maze;

import java.util.Scanner;

class MainLoop {

	private static final String OUTCONSOLE="console";
	private static final String OUTFILE="file";
	private static final String EXIT="exit";

	public void run() {

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
			Scanner ls=null;
			try {
				System.out.printf(">>>width height [file|console] (blank to finish)%n");
				String line=s.nextLine();
				ls=new Scanner(line);
				
				if(line.length()==0) {
					System.out.println("Exiting...");
					break;
				}

				Maze maze=new Maze(ls.nextInt(), ls.nextInt());
				Generator gen=new Generator();
				gen.generate(maze);
				Display display=get_display(ls.next());
				display.draw(maze);

			}
			catch(Exception e) {
				System.out.println("Something went wrong, probably your fault: "+e.getMessage());
				e.printStackTrace();
//				s.nextLine(); //Discard the input!.
			}
			finally {
				if(null!=ls) {
					ls.close();
				}
			}
		}

		if(null!=s) {
			s.close();
		}
	}

	private Display get_display(String type) throws Exception {

		if(type.equals(OUTCONSOLE)) {
			return new ConsoleDisplay();
		}
		else if(type.equals(OUTFILE)) {
			return new FileDisplay();
		}

		throw new Exception("No valid display specified");
	}
}
