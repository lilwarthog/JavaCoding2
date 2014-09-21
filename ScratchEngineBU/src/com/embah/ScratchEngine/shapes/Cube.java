package com.embah.ScratchEngine.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Cube extends Object{
	private ArrayList<Polygon> faces = new ArrayList<Polygon>();
	
	public Cube(ArrayList<Polygon> faces, Color fill, Color draw){
		this.faces = faces;
		this.setColor(fill, draw);
		updateCube();
	}
	
	public void updateCube(){
		for(int i=0;i<faces.size();i++){
			if(faces.get(i).getColor(0) != this.getColor(0) || faces.get(i).getColor(1) != this.getColor(1) ){
				faces.get(i).setColor(this.getColor(0), this.getColor(1));
			}
			faces.get(i).updatePolygon();
		}
		Polygon.sortArray(faces);
	}
	
	public ArrayList<Polygon> getPolygonList(){
		return faces;
	}

	@Override
	public void draw(Graphics g) {
		for(int i=0;i<faces.size();i++){
			faces.get(i).draw(g);
		}
	}
}
