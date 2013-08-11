package Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


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
			p.setTileY(1);
			m = new Map();
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
		
		
		if(win)
		g.drawString(message, 500, 50);
		//g.drawImage(m.getPath(),p.getTileX()*16,p.getTileY()*16,null);
		g.drawImage(p.getPlayer(), p.getTileX()*16, p.getTileY()*16, null);
			
		
	}
	
	public class ActionListener extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			int code = e.getKeyCode();
			
			if (code == KeyEvent.VK_UP) {
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
				if( m.getMap(p.getTileX()+1, p.getTileY()) != 1 )
					p.move(1, 0);
			}
			if (code == KeyEvent.VK_R){
				System.out.println("R!");
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
