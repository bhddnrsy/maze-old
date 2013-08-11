/* Player.class
 * 
 * This class have been created to let user travel on base tiles to get to the finish tile.
 * User shown as a red dot and user can move this red dot using arrow keys.
 * 
 * 
 *****************************************************************************************************************/


package Maze;

import java.awt.*;
import javax.swing.*;

//Player class
public class Player {

	private int tileX,tileY;
	private Image player;
	
	public Player(){
		
		ImageIcon img = new ImageIcon(Maze.class.getResource("/Maze/images/dot16.png"));
		player = img.getImage();
		
		//Start position of user.
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
		//Move the player on tile up,down,right or left.
		tileX += dx;
		tileY += dy;
		
	}
	
}
