package com.embah.ScratchEngine;

public class Vector3f {
	public double x = 0, y = 0, z = 0;
	
	public Vector3f(double x, double y, double z){
		double length = Math.sqrt(x*x + y*y + z*z);
		if(length>0){
			this.x = x/length;
			this.y = y/length;
			this.z = z/length;
		}
		
	}
	
	public Vector3f CrossProduct(Vector3f v){
		return new Vector3f(y * v.z - z * v.y, z * v.x - x * v.z, x * v.z - y * v.x);
	}
	
	public static double getDistance(Vector3f v1, Vector3f v2){
		return Math.pow((v2.x - v1.x), 2) + Math.pow((v2.y - v1.y), 2) + Math.pow((v2.z - v1.z), 2);
	}
}
