package Maze;

import java.awt.*;

import javax.swing.ImageIcon;

public class Player {

	private int tileX,tileY;
	private Image player;
	
	public Player(){
		
		ImageIcon img = new ImageIcon("C://Users//shock//git//maze//maze//src//Maze//images//dot16.png");
		player = img.getImage();
		
		tileX = 1;
		tileY = 1;
	}
	
	public Image getPlayer(){
		return player;
	}
	
	public int getTileX(){
		return tileX;
	}
	public int getTileY(){
		return tileY;
	}
	public void setTileX(int x){
		tileX = x;
	}
	public void setTileY(int y){
		tileY = y;
	}
	
	public void move(int dx, int dy){
		
		tileX += dx;
		tileY += dy;
		
	}
	
}
