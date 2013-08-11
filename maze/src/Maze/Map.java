/* Map.class
 * 
 * This class creates an integer 2D array with 41x37 lengths to hold the base and wall tiles.
 * I used the Depth-First Search algorithm to create our Maze, because it is easy to implement it using a recursive function.
 * Main idea is :	
 * 	Start from a random point(Here,it is (1,1)).
 *  Keep digging tiles (paths) in one of randomly-chosen 4 directions.
 *  Check if new cell will be out of maze or it is already a path. If so, do nothing.
 *  If stuck, take a step back to find an open path.
 *  Recursively implement these steps until it cannot go any further.
 * Update the Maze array according to this info.
 * 
 * 
 *****************************************************************************************************************/


package Maze;

import java.awt.*;
import java.util.*;
import javax.swing.*;

//Map class
public class Map {
	
	//Create the Maze array and load images to display.
	int width = 41;
	int height = 27;
	int[][] maze = new int[width][height];
	
	private Image base,wall,finish;
	private ImageIcon img;
	
	public Map(){
		
		img = new ImageIcon(Maze.class.getResource("/Maze/images/base16.png"));
		base = img.getImage();
		img = new ImageIcon(Maze.class.getResource("/Maze/images/wall16.jpg"));
		wall = img.getImage();
		img = new ImageIcon(Maze.class.getResource("/Maze/images/finish16.png"));
		finish = img.getImage();
		
		//Fill up the array.
		newMaze();
		
	}
	
	public Image getBase(){
		return base;
	}
	
	public Image getWall(){
		return wall;
	}
	
	public Image getFinish(){
		return finish;
	}
	
	public int getMap(int x, int y){
		return maze[x][y];
	}
	
	
	public void newMaze(){
		//Create all tiles as walls firstly.
		for(int i=0; i<41; i++){
			for(int j=0; j<27; j++){
				maze[i][j] = 1;
			}
		}
		
		//Chosen point to start.
		maze[1][1] = 0;
		
		//Start creating path from here.
		generateRecursivePath(1,1);
		
	}
	
	public void generateRecursivePath(int c, int r){
		//Generate 4 directions randomly arranged.
		Integer[] randomDirections = generateDirections();
		
		//Check for every direction if there is a wall on the way, or end of the panel.
		//Then change the wall tiles to base tiles.
		for (int i=0; i < randomDirections.length; i++){
			switch(randomDirections[i]){
			case 1://Up
				if (r-2 <= 0)
					continue;
				if (maze[c][r-2] != 0){
					maze[c][r-2] = 0;
					maze[c][r-1] = 0;
					generateRecursivePath(c, r-2);
				}
				break;
			
			case 2://Right
				if (c+2 >= width-1)
					continue;
				if (maze[c+2][r] != 0){
					maze[c+2][r] = 0;
					maze[c+1][r] = 0;
					generateRecursivePath(c+2, r);
				}
				break;
			
			case 3://Down
				if (r+2 >= height-1)
					continue;
				if (maze[c][r+2] != 0){
					maze[c][r+2] = 0;
					maze[c][r+1] = 0;
					generateRecursivePath(c, r+2);
				}
				break;
		
			case 4://Left
				if (c-2 <= 0)
					continue;
				if (maze[c-2][r] != 0){
					maze[c-2][r] = 0;
					maze[c-1][r] = 0;
					generateRecursivePath(c-2, r);
				}
				break;
			}
		}
		//Initialize finish tile.
		maze[40][25] = 2;
	}
	
	public Integer[] generateDirections(){
		//Create an array for directions, randomly arranged.
		ArrayList<Integer> randoms = new ArrayList<Integer>();
		for(int i=0; i<4; i++)
			randoms.add(i+1);
		Collections.shuffle(randoms);
		
		return randoms.toArray(new Integer[4]);
	}

}
