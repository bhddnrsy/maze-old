package Maze;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	
	private Scanner sc;
	private String map[] = new String[14];
	private Image base,wall;
	
	
	public Map(){
		
		ImageIcon img = new ImageIcon("images/base.png");
		base = img.getImage();
		
		img = new ImageIcon("images/wall.png");
		wall = img.getImage();
		
		
		
		try{
			sc = new Scanner(new File("map.txt"));
		}
		catch(Exception e){
			System.out.println("Error loading map!");
		}
		
		read();
		
		sc.close();
		
	}
	
	public Image getBase(){
		return base;
	}
	
	public Image getWall(){
		return wall;
	}
	
	public String getMap(int x, int y){
		String index = map[y].substring(x,x+1);
		return index;
	}
	
	public void read(){
		while(sc.hasNext()){
			for(int i=0; i<14; i++){
				map[i] = sc.next();
			}
		}
	}

}