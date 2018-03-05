package net.caballorenoir.maze;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.EnumSet;

class GUIDisplayPanel extends JPanel {

	private static final int SIZE=10;
	private Maze maze=null;

	public GUIDisplayPanel(Maze _m) {
		maze=_m;
	}

	public Dimension getPreferredSize() {
/*		Insets i=getInsets();
		return new Dimension( (maze.get_width()+i.left+i.right)*SIZE, (maze.get_height()+i.top+i.bottom)*SIZE);
*/
		//TODO: oh well, the right borders are not being drawn...
		return new Dimension(maze.get_width()*SIZE, maze.get_height()*SIZE);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Coords coords=new Coords(0,0);
		for(int x=0; x<maze.get_width(); x++) {
			for(int y=0; y<maze.get_height(); y++) {
				coords.x=x;
				coords.y=y;
				draw_cell(g, maze.get_cell(coords), coords);
			}
		}
	}  

	private void draw_cell(Graphics _g, Cell _cell, Coords _coords) {

		EnumSet<Tools.DirFlag> blocked=_cell.get_blocked_directions();
		if(blocked.contains(Tools.DirFlag.up)) {
			grid_line(_g, _coords.x, _coords.y, _coords.x+1, _coords.y);
		}
		if(blocked.contains(Tools.DirFlag.right)) {
			grid_line(_g, _coords.x+1, _coords.y, _coords.x+1, _coords.y+1);
		}
		if(blocked.contains(Tools.DirFlag.down)) {
			grid_line(_g, _coords.x, _coords.y+1, _coords.x+1, _coords.y+1);
		}
		if(blocked.contains(Tools.DirFlag.left)) {
			grid_line(_g, _coords.x, _coords.y, _coords.x, _coords.y+1);
		}
	}

	private void grid_line(Graphics _g, int _p1x, int _p1y, int _p2x, int _p2y) {
		_g.drawLine(_p1x*SIZE, _p1y*SIZE, _p2x*SIZE, _p2y*SIZE);
	}
}
