package com.embah.ScratchEngine.shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Object {
	private boolean visible = true;
	private boolean fillMesh = true, drawMesh = true;
	private int id;
	private Color fill, draw;
	
	public void setVisible(boolean isVisible){
		visible = isVisible;
	}
	
	public void setDrawAttributes(int attribute, boolean status){
		if(attribute == 0){
			fillMesh = status;
		} else {
			drawMesh = status;
		}
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setColor(Color fill, Color draw){
		this.fill = fill;
		this.draw = draw;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public boolean getDrawAttribute(int attribute){
		return attribute == 0 ? fillMesh : drawMesh;
	}
	
	public int getId(){
		return id;
	}
	
	public Color getColor(int attribute){
		return attribute == 0 ? fill : draw;
	}
	
	public abstract void draw(Graphics g);
}
