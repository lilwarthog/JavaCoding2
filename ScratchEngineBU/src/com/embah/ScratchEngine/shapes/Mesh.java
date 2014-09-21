package com.embah.ScratchEngine.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Mesh extends Object{
	private ArrayList<Polygon> faces = new ArrayList<Polygon>();
	
	public Mesh(ArrayList<Polygon> faces, Color fill, Color draw){
		this.faces = faces;
		this.setColor(fill, draw);
		updateMesh();
	}
	
	public void updateMesh(){
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
