package com.embah.ScratchEngine.shapes;

import java.awt.Polygon;

public class Polygon2D {
	private Polygon p;
	
	public Polygon2D(double[] x, double[] y){
		p = new Polygon();
		for(int i=0;i<x.length;i++){
			p.addPoint((int) x[i], (int) y[i]);
		}
	}
	
	public void updatePoints(double[] x, double[] y){
		p.reset();
		for(int i=0;i<x.length;i++){
			p.addPoint((int) x[i], (int) y[i]);
		}
	}
	
	public Polygon getDrawablePolygon(){
		return p;
	}
}
