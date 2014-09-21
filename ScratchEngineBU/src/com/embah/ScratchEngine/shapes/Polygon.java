package com.embah.ScratchEngine.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import com.embah.ScratchEngine.Camera;
import com.embah.ScratchEngine.Drawing.DepthCalculator;

public class Polygon extends Object{
	private double[] x, y, z;
	private double[] TwoDX, TwoDY;
	private double AvgDis;
	private Polygon2D depthImg;
	
	public Polygon(double[] x, double[] y, double[] z, Color fill, Color draw){
		this.x = x;
		this.y = y;
		this.z = z;
		TwoDX = new double[x.length];
		TwoDY = new double[y.length];
		setColor(fill, draw);
		double dx = - 50 * DepthCalculator.CalPosX(Camera.ViewFrom, Camera.ViewTo, Camera.ViewTo[0], Camera.ViewTo[1], Camera.ViewTo[2]);
		double dy = - 50 * DepthCalculator.CalPosY(Camera.ViewFrom, Camera.ViewTo, Camera.ViewTo[0], Camera.ViewTo[1], Camera.ViewTo[2]);
		
		for(int i=0;i<x.length;i++){
			TwoDX[i] = dx + Toolkit.getDefaultToolkit().getScreenSize().width/2 + 50 * DepthCalculator.CalPosX(Camera.ViewFrom, Camera.ViewTo, x[i], y[i], z[i]);
			TwoDY[i] = dy + Toolkit.getDefaultToolkit().getScreenSize().height/2 + 50 * DepthCalculator.CalPosY(Camera.ViewFrom, Camera.ViewTo, x[i], y[i], z[i]);
		}
		
		depthImg = new Polygon2D(TwoDX, TwoDY);
		AvgDis = getDist();
	}
	
	public void updatePolygon(){
		TwoDX = new double[x.length];
		TwoDY = new double[y.length];
		double dx = - 50 * DepthCalculator.CalPosX(Camera.ViewFrom, Camera.ViewTo, Camera.ViewTo[0], Camera.ViewTo[1], Camera.ViewTo[2]);
		double dy = - 50 * DepthCalculator.CalPosY(Camera.ViewFrom, Camera.ViewTo, Camera.ViewTo[0], Camera.ViewTo[1], Camera.ViewTo[2]);
		
		for(int i=0;i<x.length;i++){
			TwoDX[i] = dx + Toolkit.getDefaultToolkit().getScreenSize().width/2 + 50 * DepthCalculator.CalPosX(Camera.ViewFrom, Camera.ViewTo, x[i], y[i], z[i]);
			TwoDY[i] = dy + Toolkit.getDefaultToolkit().getScreenSize().height/2 + 50 * DepthCalculator.CalPosY(Camera.ViewFrom, Camera.ViewTo, x[i], y[i], z[i]);
		}
		depthImg.updatePoints(TwoDX, TwoDY);
		AvgDis = getDist();
	}
	
	private double getDist(){
		double total = 0;
		for(int i=0;i<x.length;i++){
			total+=getDisFromPoint(i);
		}
		return total / x.length;
	}
	
	private double getDisFromPoint(int len){
		return Math.sqrt((Camera.ViewFrom[0] - x[len]) * (Camera.ViewFrom[0] - x[len]) +
						 (Camera.ViewFrom[1] - y[len]) * (Camera.ViewFrom[1] - y[len]) +
						 (Camera.ViewFrom[2] - z[len]) * (Camera.ViewFrom[2] - z[len]));
	}
	
	public ArrayList<Polygon> getPolygonList(){
		ArrayList<Polygon> polyG = new ArrayList<Polygon>();
		polyG.add(this);
		return polyG;
	}
	
	public static void sortArray(ArrayList<Polygon> poly){
		for(int i=0;i<poly.size() - 1;i++){
			for(int j=0;j<poly.size()-i-1;j++){
				if(poly.get(j).getAvgDistance() > poly.get(i + 1).getAvgDistance()){
					Polygon temp = poly.get(j);
					poly.set(j, poly.get(j + 1));
					poly.set(j + 1, temp);
				}
			}
		}
	}
	
	public double getAvgDistance(){
		return AvgDis;
	}
	
	@Override
	public void draw(Graphics g) {
		updatePolygon();
		if(this.getDrawAttribute(0) && isVisible()){
			g.setColor(this.getColor(0));
			g.fillPolygon(depthImg.getDrawablePolygon());
		}
		if(this.getDrawAttribute(1) && isVisible()){
			g.setColor(this.getColor(1));
			g.drawPolygon(depthImg.getDrawablePolygon());
		}
	}
}
