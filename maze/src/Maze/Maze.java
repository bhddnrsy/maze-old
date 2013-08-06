package Maze;

import java.awt.*;

import javax.swing.*;

public class Maze {
	
	JPanel rPanel;
	JLabel lbl;
	Board brd;
	
	public static void main(String[] args){
		new Maze();
	}
	
	public Maze(){
		
		rPanel = new JPanel();
		rPanel.setLayout(new BorderLayout());
		
		lbl = new JLabel("asdasd");
		rPanel.add(lbl,BorderLayout.CENTER);
		
		brd = new Board();
		
		JFrame fr = new JFrame();
		fr.setLayout(new BorderLayout());
		fr.setTitle("Maze Game");
		fr.setSize(600,476);
		//fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		
		fr.add(brd,BorderLayout.CENTER);
		fr.add(rPanel,BorderLayout.EAST);
		
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
