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
		g.setColor(Color.red);
		g.fillRect(45, 60, 32, 32);
	}
	
}
