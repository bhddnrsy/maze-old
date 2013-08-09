package Maze;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class Map {
	
	private Scanner sc;
	private String map[] = new String[28];
	private Image base,wall,finish;
	private Random rand;
	
	
	public Map(){
		
		ImageIcon img = new ImageIcon("C://Users//shock//git//maze//maze//src//Maze//images//base16.png");
		base = img.getImage();
		
		img = new ImageIcon("C://Users//shock//git//maze//maze//src//Maze//images//wall16.jpg");
		wall = img.getImage();
		img = new ImageIcon("C://Users//shock//git//maze//maze//src//Maze//images//finish16.png");
		finish = img.getImage();
		
		
		try{
			sc = new Scanner(new File("C://Users//shock//git//maze//maze//src//Maze//map.txt"));
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
	
	public Image getFinish(){
		return finish;
	}
	
	public String getMap(int x, int y){
		String index = map[y].substring(x,x+1);
		return index;
	}
	
	public void setMap(){
		System.out.println("R2!");
		rand = new Random();
		boolean b = false;
		int t = 0;
		try {
			PrintWriter writer = new PrintWriter("C://Users//shock//git//maze//maze//src//Maze//map.txt","UTF-8");
			writer.println("wwwwwwwwwwwwwwwwwwwwwwwwwwww");
			for (int i=1;i<27;i++){
				writer.println("wggggggggggggggggggggggggggw");
			}
			/*
			for(int x=2;x<26;x=x+2){
				for(int y=1;y<27;y++){
					rand = new Random();
					if (rand.nextInt(1) == 0){
						System.out.println("oops" + t);
						writer.print("w");
						t++;
					}
				}
			}*/
			writer.println("wwwwwwwwwwwwwwwwwwwwwwwwwwww");
			System.out.println("DONE");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//while(){
		//	b = rand.nextBoolean();	
		//}
		
	}
	
	public void read(){
		while(sc.hasNext()){
			for(int i=0; i<28; i++){
				map[i] = sc.next();
			}
		}
	}

}
