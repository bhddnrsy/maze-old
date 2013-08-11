package Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Maze implements java.awt.event.ActionListener {
	
	JPanel labelPanel;
	JButton random;
	JLabel lbl1,lbl2;
	Board mazePanel;
	JFrame fr;
	Timer timer;
	ImageIcon icon;
	int sec;
	boolean getR = false;
	
	public static void main(String[] args){
		new Maze();
	}
	
	public Maze(){
		
		icon = new ImageIcon(Maze.class.getResource("/Maze/images/MazeIcon.jpg"));
		sec = 0;
		lbl1 = new JLabel("Press \"R\" to change the maze path.");
		lbl2 = new JLabel(" " + sec/60 + " min. " + sec%60 + " sec. ");
		
		mazePanel = new Board();
		
		timer = new Timer(1000, this);
		timer.start();
		
		labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		labelPanel.add(lbl1,BorderLayout.WEST);
		labelPanel.add(lbl2,BorderLayout.EAST);
		
		fr = new JFrame();
		fr.setIconImage(icon.getImage());
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
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == timer){
			sec++;
			lbl2.setText(" " + sec/60 + " min. " + sec%60 + " sec. ");
			
			if(mazePanel.getWin() == true){
				timer.stop();
				lbl2.setText("You finished the maze at " + sec/60 + " min. " + sec%60 + " sec. ");
			}
			
		}
	}
	
	public class Board extends JPanel implements ActionListener {
		
		
		private static final long serialVersionUID = 1L;
		private Timer timer;
		private Map m;
		private Player p;
		private String message="";
		private boolean win = false;
		private boolean newRand = false;
		
		public Board(){
			m = new Map();
			p = new Player();
			
			addKeyListener(new ActionListener());
			setFocusable(true);
			timer = new Timer(20, this);
			timer.start();
		}
		
		public void actionPerformed(ActionEvent e){
			
			if(m.getMap(p.getTileX(), p.getTileY()) == 2){
				message ="You won!";
				win = true;
			}
			if(newRand == true){
				p.setTileX(1);
				p.setTileY(0);
				m = new Map();
				sec=0;
				win=false;
				Maze.this.timer.restart();
				Maze.this.lbl2.setText(" " + sec/60 + " min. " + sec%60 + " sec. ");
				//newRand = false;
			}
			repaint();
		}
		
		public void paint(Graphics g){
			super.paint(g);
			newRand = false;
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
			
			
			g.drawImage(p.getPlayer(), p.getTileX()*16, p.getTileY()*16, null);
				
			
		}
		
		public class ActionListener extends KeyAdapter{
			
			public void keyPressed(KeyEvent e){
				int code = e.getKeyCode();
				
				if (code == KeyEvent.VK_UP) {
					if(p.getTileY() != 0)
						if( m.getMap(p.getTileX(), p.getTileY()-1) != 1 )
							p.move(0, -1);
				}
				if (code == KeyEvent.VK_DOWN) {
					if( m.getMap(p.getTileX(), p.getTileY()+1) != 1 )
						p.move(0, 1);
				}
				if (code == KeyEvent.VK_LEFT) {
					if( m.getMap(p.getTileX()-1, p.getTileY()) != 1 )
						p.move(-1, 0);
				}
				if (code == KeyEvent.VK_RIGHT) {
					if(p.getTileX() != 40)
						if( m.getMap(p.getTileX()+1, p.getTileY()) != 1 )
							p.move(1, 0);
				}
				if (code == KeyEvent.VK_R){
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
