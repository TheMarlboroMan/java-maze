package net.caballorenoir.maze;

import javax.swing.JFrame;

class GUIDisplay implements Display {

	private JFrame frame=null;

	public GUIDisplay() {
		frame=new JFrame("Here is your maze!");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void draw(Maze _maze) throws Exception {
		GUIDisplayPanel panel=new GUIDisplayPanel(_maze);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
