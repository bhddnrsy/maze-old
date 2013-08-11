package Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Maze {
	
	JPanel labelPanel;
	JButton random;
	JLabel lbl1,lbl2;
	Board mazePanel;
	JFrame fr;
	Timer timer;
	int sec;
	
	public static void main(String[] args){
		new Maze();
		//ActionListener acL = new ActionListener();
	}
	
	public Maze(){
		
		sec = 0;
		lbl1 = new JLabel("Press \"R\" for randomize.");
		lbl2 = new JLabel("");
		
		mazePanel = new Board();
		
		ActionListener acL = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				sec++;
				lbl2.setText(" " + sec/60 + " min. " + sec%60 + " sec. ");
				if (mazePanel.getNewRand() == true){
					System.out.println("true!!!!");
					timer.stop();
					sec=0;
					timer.restart();
				}
				if(mazePanel.getWin() == true){
					timer.stop();
					lbl2.setText("You finished the maze at " + sec/60 + " min. " + sec%60 + " sec. ");
					if (mazePanel.getNewRand() == true){
						System.out.println("true!!!!222");
						sec = 0;
						lbl2.setText(" " + sec/60 + " min. " + sec%60 + " sec. ");
						timer.restart();
					}
				}
			}
		};
		timer = new Timer(1000, acL);
		timer.start();
		
		labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		labelPanel.add(lbl1,BorderLayout.WEST);
		labelPanel.add(lbl2,BorderLayout.EAST);
		
		fr = new JFrame();
		fr.setLayout(new BorderLayout());
		fr.setTitle("Maze Game");
		fr.setSize(672,488);
		//fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		
		fr.add(mazePanel,BorderLayout.CENTER);
		fr.add(labelPanel,BorderLayout.SOUTH);
		
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
}
