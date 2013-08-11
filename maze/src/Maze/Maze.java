/* Maze.class
 * 	Inner classes: Board.class
 * 
 * These classes create the frame and included panels to display the maze and instructions.
 * There are 2 timer objects to hold gaming time and paint the wall and base tiles runtime.
 * Key Adapters handle conclusions between red dot and wall tiles and let user to move red dot on base tiles. 
 * paint(Graphics g) method prints the walls and bases according to the int array Maze[width][height].
 * I created Board class as an inner class of Maze, because of using timer and label in this class.
 * 
 * Press "R" button from keyboard to randomize the Maze path and restart.
 * Press arrow keys from keyboard to control red dot and make it to the finish line.
 * 
 * 
 *****************************************************************************************************************/

package Maze;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Maze class
public class Maze implements ActionListener {
	
	JPanel labelPanel;
	JLabel lbl1,lbl2;
	JFrame fr;
	Board mazePanel;
	Timer timer;
	ImageIcon icon;
	int sec;
	
	public static void main(String[] args){
		new Maze();
	}
	
	public Maze(){
		
		//Used a new window icon.
		icon = new ImageIcon(Maze.class.getResource("/Maze/images/MazeIcon.jpg"));
		
		//sec variable will be incremented every one second.
		sec = 0;
		
		//Created labels and Board panel.
		lbl1 = new JLabel("Press \"R\" to change the maze path.");
		lbl2 = new JLabel(" " + sec/60 + " min. " + sec%60 + " sec. ");
		mazePanel = new Board();
		
		//Start the timer when our board constructed.
		timer = new Timer(1000, this);
		timer.start();
		
		//Set layouts for labels and join them in the frame.
		labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		labelPanel.add(lbl1,BorderLayout.WEST);
		labelPanel.add(lbl2,BorderLayout.EAST);
		
		fr = new JFrame();
		fr.setIconImage(icon.getImage());
		fr.setLayout(new BorderLayout());
		fr.setTitle("Maze Game");
		fr.setSize(662,478);
		fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		
		fr.add(mazePanel,BorderLayout.CENTER);
		fr.add(labelPanel,BorderLayout.SOUTH);
		
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		//Update the label as "x min x sec." in every second.
		if(e.getSource() == timer){
			sec++;
			lbl2.setText(" " + sec/60 + " min. " + sec%60 + " sec. ");
			
			//Update the label when user finished all the course.
			if(mazePanel.getWin() == true){
				timer.stop();
				lbl2.setText("You finished the maze at " + sec/60 + " min. " + sec%60 + " sec. ");
			}
			
		}
	}
	
	//Board class
	public class Board extends JPanel implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		private Timer timer;
		private Map m;
		private Player p;
		private boolean win = false;
		private boolean newRand = false;
		
		public Board(){
			//Create the map and player.
			m = new Map();
			p = new Player();
			
			//Add key controls.
			addKeyListener(new ActionListener());
			setFocusable(true);
			
			//Created timer for key controls.
			timer = new Timer(20, this);
			timer.start();
		}
		
		public void actionPerformed(ActionEvent e){
			//Check if player made it to the finish line.
			if(m.getMap(p.getTileX(), p.getTileY()) == 2){
				win = true;
			}
			//If R button pressed, game will be restarted with a randomized Maze path.
			if(newRand == true){
				//Set player to the start point.
				p.setTileX(1);
				p.setTileY(0);
				
				//Create new Map and set timer count 0.
				m = new Map();
				sec = 0;
				win = false;
				newRand = false;
				
				//Restart the timer.
				Maze.this.timer.restart();
				Maze.this.lbl2.setText(" " + sec/60 + " min. " + sec%60 + " sec. ");
			}
			//Repaint to see changes.
			repaint();
		}
		
		public void paint(Graphics g){
			super.paint(g);
			
			//Draw all the bases,walls and finish tile.
			//All x and y values multiplied by 16 because we used 16x16 pixel images.
			for (int x=0; x<41; x++){
				for (int y=0; y<27; y++){
					
					if(m.getMap(x,y) == 2){
						g.drawImage(m.getFinish(),x*16,y*16,null);
					}
					if(m.getMap(x, y) == 0){
						g.drawImage(m.getBase(), x*16, y*16, null);
					}
					if(m.getMap(x, y) == 1){
						g.drawImage(m.getWall(), x*16, y*16, null);
					}
					
				}
			}
			//Draw the user's red dot.
			g.drawImage(p.getPlayer(), p.getTileX()*16, p.getTileY()*16, null);
			
		}
		
		public class ActionListener extends KeyAdapter{
			//User control.
			public void keyPressed(KeyEvent e){
				int code = e.getKeyCode();
				
				if (code == KeyEvent.VK_UP) {//Move player up.
					if(p.getTileY() != 0) 
						if( m.getMap(p.getTileX(), p.getTileY()-1) != 1 )
							p.move(0, -1);
				}
				
				if (code == KeyEvent.VK_DOWN) {//Move player down.
					if( m.getMap(p.getTileX(), p.getTileY()+1) != 1 )
						p.move(0, 1);
				}
				
				if (code == KeyEvent.VK_LEFT) {//Move player left.
					if( m.getMap(p.getTileX()-1, p.getTileY()) != 1 )
						p.move(-1, 0);
				}
				
				if (code == KeyEvent.VK_RIGHT) {//Move player right.
					if(p.getTileX() != 40)
						if( m.getMap(p.getTileX()+1, p.getTileY()) != 1 )
							p.move(1, 0);
				}
				
				if (code == KeyEvent.VK_R){//Randomize the Maze path.
					newRand = true;
				}
				
			}
			
		}
		
		public boolean getNewRand(){
			return newRand;
		}
		
		public boolean getWin(){
			return win;
		}
		
	}
	
}
