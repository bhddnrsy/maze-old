package Maze;

import java.awt.*;

import javax.swing.ImageIcon;

public class Player {

	private int x,y,tileX,tileY;
	private Image player;
	
	public Player(){
		
		ImageIcon img = new ImageIcon("C://Users//shock//git//maze//maze//src//Maze//images//dot16.png");
		player = img.getImage();
		x=16;
		y=16;
		tileX = 1;
		tileY = 1;
	}
	
	public Image getPlayer(){
		return player;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getTileX(){
		return tileX;
	}
	public int getTileY(){
		return tileY;
	}
	
	public void move(int dx, int dy, int tx, int ty){
		
		x += dx;
		y += dy;
		
		tileX += tx;
		tileY += ty;
		
	}
	
}
