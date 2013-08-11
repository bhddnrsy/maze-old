package Maze;

import java.awt.*;

import javax.swing.ImageIcon;

public class Player {

	private int tileX,tileY;
	private Image player;
	
	public Player(){
		
		ImageIcon img = new ImageIcon(Maze.class.getResource("/Maze/images/dot16.png"));
		player = img.getImage();
		
		tileX = 1;
		tileY = 0;
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
