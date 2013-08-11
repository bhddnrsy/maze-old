package Maze;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class Map {
	
	private Scanner sc;
	//private String map[] = new String[28];
	int width = 41;
	int height = 27;
	int[][] maze = new int[width][height];
	
	private Image base,wall,finish,path;
	private Random rand;
	
	
	public Map(){
		
		ImageIcon img = new ImageIcon(Maze.class.getResource("/Maze/images/base16.png"));
		base = img.getImage();
		
		img = new ImageIcon(Maze.class.getResource("/Maze/images/wall16.jpg"));
		wall = img.getImage();
		img = new ImageIcon(Maze.class.getResource("/Maze/images/finish16.png"));
		finish = img.getImage();
		img = new ImageIcon(Maze.class.getResource("/Maze/images/reddot16.png"));
		path = img.getImage();
		
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
	public Image getPath(){
		return path;
	}
	
	public int getMap(int x, int y){
		return maze[x][y];
	}
	
	
	public void newMaze(){
		for(int i=0; i<41; i++){
			for(int j=0; j<27; j++){
				maze[i][j] = 1;
			}
		}
		maze[3][5] = 0;
		
		generateRecursion(3,5);
		
	}
	
	public void generateRecursion(int c, int r){
		Integer[] randomDirections = generateDirections();
		
		for (int i=0; i < randomDirections.length; i++){
			//System.out.println("in for");
			switch(randomDirections[i]){
			case 1://Up
				//System.out.println("1) r:"+r+" c:"+c);
				if (r-2 <= 0)
					continue;
				if (maze[c][r-2] != 0){
					maze[c][r-2] = 0;
					maze[c][r-1] = 0;
					generateRecursion(c, r-2);
				}
				break;
			
			case 2://Right
				//System.out.println("2) r:"+r+" c:"+c);
				if (c+2 >= width-1)
					continue;
				if (maze[c+2][r] != 0){
					maze[c+2][r] = 0;
					maze[c+1][r] = 0;
					generateRecursion(c+2, r);
				}
				break;
			
			case 3://Down
				//System.out.println("3) r:"+r+" c:"+c);
				if (r+2 >= height-1)
					continue;
				if (maze[c][r+2] != 0){
					maze[c][r+2] = 0;
					maze[c][r+1] = 0;
					generateRecursion(c, r+2);
				}
				break;
		
			case 4://Left
				//System.out.println("4) r:"+r+" c:"+c);
				if (c-2 <= 0)
					continue;
				if (maze[c-2][r] != 0){
					maze[c-2][r] = 0;
					maze[c-1][r] = 0;
					generateRecursion(c-2, r);
				}
				break;
			}
		}
		maze[40][25] = 2;
	}
	
	public Integer[] generateDirections(){
		ArrayList<Integer> randoms = new ArrayList<Integer>();
		for(int i=0; i<4; i++)
			randoms.add(i+1);
		Collections.shuffle(randoms);
		
		return randoms.toArray(new Integer[4]);
	}

}
