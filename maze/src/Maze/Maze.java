package Maze;

import javax.swing.*;

public class Maze {
	public static void main(String[] args){
		new Maze();
	}
	
	public Maze(){
		JFrame fr = new JFrame();
		fr.setTitle("Maze Game");
		fr.setSize(464,486);
		fr.setLocationRelativeTo(null);
		fr.add(new Board());
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
