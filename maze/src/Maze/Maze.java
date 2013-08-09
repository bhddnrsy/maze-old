package Maze;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Maze {
	
	JPanel rPanel;
	JButton random;
	JLabel lbl;
	Board brd;
	JFrame fr;
	
	public static void main(String[] args){
		new Maze();
	}
	
	public Maze(){
		lbl = new JLabel("Press \"R\" for randomize.");
		brd = new Board();
		
		fr = new JFrame();
		fr.setLayout(new BorderLayout());
		fr.setTitle("Maze Game");
		fr.setSize(464,504);
		//fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		
		fr.add(brd,BorderLayout.CENTER);
		fr.add(lbl,BorderLayout.SOUTH);
		
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
}
