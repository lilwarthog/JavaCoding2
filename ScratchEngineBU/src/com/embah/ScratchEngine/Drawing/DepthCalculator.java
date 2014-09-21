package com.embah.ScratchEngine.Drawing;

import com.embah.ScratchEngine.Vector3f;

public class DepthCalculator {
	private static double DrawX = 0, DrawY = 0;
	
	public static double CalPosX(double[] viewFrom, double[] viewTo, double x, double y, double z){
		set(viewFrom, viewTo, x, y, z);
		return DrawX;
	}
	
	public static double CalPosY(double[] viewFrom, double[] viewTo, double x, double y, double z){
		set(viewFrom, viewTo, x, y, z);
		return DrawY;
	}
	
	public static void set(double[] ViewFrom, double[] ViewTo, double x, double y, double z){
		Vector3f ViewVector = new Vector3f(ViewTo[0] - ViewFrom[0], ViewTo[1] - ViewFrom[1], ViewTo[2] - ViewFrom[2]);
		Vector3f DirectionVector = new Vector3f(1, 1, 1);
		//Vector3f PlaneVector1 = ViewVector.CrossProduct(DirectionVector);
		//Vector3f PlaneVector2 = ViewVector.CrossProduct(PlaneVector1);
		
		Vector3f ViewToPoint = new Vector3f(x - ViewFrom[0], y - ViewFrom[1], z - ViewFrom[2]);
		
		Vector3f rotationVector = getRotation(ViewFrom, ViewTo);
		Vector3f crossRotation = ViewVector.CrossProduct(rotationVector);
		Vector3f cross2Rotation = ViewVector.CrossProduct(crossRotation);
		
		double t = (ViewVector.x*ViewTo[0] + ViewVector.y*ViewTo[1] + ViewVector.z*ViewTo[2]
				 - (ViewVector.x*ViewFrom[0] + ViewVector.y*ViewFrom[1] + ViewVector.z*ViewFrom[2]))
				 / (ViewVector.x*ViewToPoint.x + ViewVector.y*ViewToPoint.y + ViewVector.z*ViewToPoint.z);
		
		x = ViewFrom[0] + ViewToPoint.x * t;
		y = ViewFrom[1] + ViewToPoint.y * t;
		z = ViewFrom[2] + ViewToPoint.z * t;

		if(t>=0){
			DrawX = cross2Rotation.x * x + cross2Rotation.y + cross2Rotation.z * z;
			DrawY = crossRotation.x * x + crossRotation.y + crossRotation.z * z;
		}
	}
	
	private static Vector3f getRotation(double[] ViewFrom, double[] ViewTo){
		double dx = Math.abs(ViewFrom[0]-ViewTo[0]);
		double dy = Math.abs(ViewFrom[1]-ViewTo[1]);
		double xRot, yRot;
		xRot=dy/(dx+dy);
		yRot=dx/(dx+dy);
		if(ViewFrom[1]>ViewTo[1])
			xRot = -xRot;
		if(ViewFrom[0]>ViewTo[0])
			yRot = -yRot;
		return new Vector3f(xRot, yRot, 0); //z
	}
}
