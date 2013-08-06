package Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Board extends JPanel implements ActionListener {
	
	private Timer timer;
	private Map m;
	
	public Board(){
		
		m = new Map();
		timer = new Timer(25, this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e){
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		for (int y=0; y<28; y++){
			for (int x=0; x<28; x++){
				
				if(m.getMap(x, y).equals("g")){
					g.drawImage(m.getBase(), x*16, y*16, null);
				}
				if(m.getMap(x, y).equals("w")){
					g.drawImage(m.getWall(), x*16, y*16, null);
				}
				
			}
		}
		
	}
	
}
