package com.embah.ScratchEngine.Drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import com.embah.ScratchEngine.Camera;
import com.embah.ScratchEngine.shapes.Cube;
import com.embah.ScratchEngine.shapes.Mesh;
import com.embah.ScratchEngine.shapes.Polygon;

public class Render implements Painter{
	public static ObjectWorld world = new ObjectWorld();
	
	public Polygon poly3d = new Polygon(new double[]{2, 4, 2}, new double[]{2, 4, 6}, new double[]{5, 5, 5}, Color.CYAN, Color.BLUE);
	public Polygon[] polyarray = new Polygon[]{new Polygon(new double[]{0, 2, 2, 0}, new double[]{0, 0, 2, 2}, new double[]{0, 0, 0, 0}, Color.GRAY, Color.BLACK),
									    	   new Polygon(new double[]{0, 2, 2, 0}, new double[]{0, 0, 2, 2}, new double[]{7, 7, 7, 7}, Color.GRAY, Color.BLACK),
									    	   new Polygon(new double[]{0, 2, 2, 0}, new double[]{0, 0, 0, 0}, new double[]{0, 0, 7, 7}, Color.GRAY, Color.BLACK),
									    	   new Polygon(new double[]{0, 2, 2, 0}, new double[]{2, 2, 2, 2}, new double[]{0, 0, 7, 7}, Color.GRAY, Color.BLACK),
									    	   new Polygon(new double[]{0, 0, 0, 0}, new double[]{0, 2, 2, 0}, new double[]{0, 0, 7, 7}, Color.GRAY, Color.BLACK),
									    	   new Polygon(new double[]{2, 2, 2, 2}, new double[]{0, 2, 2, 0}, new double[]{0, 0, 7, 7}, Color.GRAY, Color.BLACK)};
	
	
	public ArrayList<Polygon> polygons = new ArrayList<Polygon>();
	public ArrayList<Polygon> floorPolys = new ArrayList<Polygon>();
	
	public Cube basicCube;
	public Cube floor;
	
	public Render(){		
		
		
		for(int i=0;i<polyarray.length;i++){
			polygons.add(polyarray[i]);
		}
//		System.out.println("Flooring start");
//		for(int i=-4;i<5;i++){ //x
//			for(int j=-4;j<5;j++){ //y
//				System.out.println("floorPolys.add(new Polygon(new double[]{" + i + ", " + i + ", " + (i + 1) + ", " + (i + 1) + "}, new double[]{" + j + ", " + (j + 1) + ", " + (j + 1) + ", " + j + "}, new double[]{5, 5, 5, 5}, Color.GREEN, Color.BLACK));");
//				floorPolys.add(new Polygon(new double[]{i, i, i + 1, i + 1}, new double[]{j, j + 1, j + 1, j}, new double[]{5, 5, 5, 5}, Color.GREEN, Color.BLACK));
//			}
//		}
//		System.out.println("Flooring end");
		floor = new Cube(floorPolys, Color.GREEN, Color.BLACK);
		floor.setId(420);
		floor.setDrawAttributes(0, true);
		floor.setDrawAttributes(1, true);
		world.addObject(floor);
		
		basicCube = new Cube(polygons, Color.gray, Color.black);
		basicCube.setId(513);
		basicCube.setDrawAttributes(0, true);
		basicCube.setDrawAttributes(1, true);
		world.addObject(basicCube);
		
		poly3d.setId(1);
		poly3d.setDrawAttributes(0, true);
		poly3d.setDrawAttributes(1, true);
		world.addObject(poly3d);
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		g.drawString(System.currentTimeMillis() + "", 10, 10);
		g.drawString("ViewFrom{" + Camera.ViewFrom[0] + ", " + Camera.ViewFrom[1] + ", " + Camera.ViewFrom[2], 10, 25);

		world.getObjectByID(513).draw(g);
		world.getObjectByID(1).draw(g);
		world.getObjectByID(420).draw(g);
	}
	
	
}
