package com.embah.ScratchEngine.Drawing;

import java.util.ArrayList;

import com.embah.ScratchEngine.shapes.Object;
import com.embah.ScratchEngine.shapes.Polygon;

public class ObjectWorld {
	private ArrayList<Object> objs = new ArrayList<Object>();
	
	public void addObject(Object o){
		objs.add(o);
	}
	
	public ArrayList<Object> getObjects(){
		return objs;
	}
	
	public Object getObjectByID(int id){
		for(int i=0;i<objs.size();i++){
			if(objs.get(i).getId() == id){
				return objs.get(i);
			}
		}
		return null;
	}
}
