package com.embah.ScratchEngine.Utilities;

import java.awt.Component;

import com.embah.ScratchEngine.Camera;
import com.embah.ScratchEngine.Vector3f;
import com.embah.ScratchEngine.Input.Keyboard;

public class Time extends Thread{
	private static double frameRate = 30.0;
	private final static double SleepTime = 1000.0 / frameRate;
	private static double lastRefresh = 0.0;
	private static Component c;
	
	public Time(Component c){
		Time.c = c;
	}
	
	public void run(){
		while(true){
			SleepAndRefresh();
		}
	}
	
	public static void SleepAndRefresh(){
		while(true){
			if((System.currentTimeMillis() - lastRefresh) > SleepTime){
				updateCamera();
				lastRefresh = System.currentTimeMillis();
				c.repaint();
				break;
			} else {
				try {
					Thread.sleep((long)(SleepTime));
				} catch(Exception e){
				}
			}
		}
	}
	
	private static void updateCamera(){
		Vector3f ViewVector = new Vector3f(Camera.ViewTo[0] - Camera.ViewFrom[0], Camera.ViewTo[1] - Camera.ViewFrom[1], Camera.ViewTo[2] - Camera.ViewFrom[2]);
		if(Keyboard.getKeys()[4]){
			Camera.ViewFrom[0] += ViewVector.x;
			Camera.ViewFrom[1] += ViewVector.y;
			Camera.ViewFrom[2] += ViewVector.z;
			Camera.ViewTo[0] += ViewVector.x;
			Camera.ViewTo[1] += ViewVector.y;
			Camera.ViewTo[2] += ViewVector.z;
		}
		if(Keyboard.getKeys()[6]){
			Camera.ViewFrom[0] -= ViewVector.x;
			Camera.ViewFrom[1] -= ViewVector.y;
			Camera.ViewFrom[2] -= ViewVector.z;
			Camera.ViewTo[0] -= ViewVector.x;
			Camera.ViewTo[1] -= ViewVector.y;
			Camera.ViewTo[2] -= ViewVector.z;
		}
		
		Vector3f vertical = new Vector3f(0, 0, 1);
		Vector3f sideView = ViewVector.CrossProduct(vertical);
		if(Keyboard.getKeys()[5]){
			Camera.ViewFrom[0] += sideView.x;
			Camera.ViewFrom[1] += sideView.y;
			//Camera.ViewFrom[2] += sideView.z;
			Camera.ViewTo[0] += sideView.x;
			Camera.ViewTo[1] += sideView.y;
			//Camera.ViewTo[2] += sideView.z;
		}
		if(Keyboard.getKeys()[7]){
			Camera.ViewFrom[0] -= sideView.x;
			Camera.ViewFrom[1] -= sideView.y;
			Camera.ViewTo[0] -= sideView.x;
			Camera.ViewTo[1] -= sideView.y;
		}
		
		if(Keyboard.getKeys()[1]){
			//Camera.ViewTo[0] -= ViewVector.x;
			Camera.ViewTo[1] -= ViewVector.y;
			Camera.ViewTo[2] -= ViewVector.z;
		}
		if(Keyboard.getKeys()[0]){
			//Camera.ViewTo[0] += ViewVector.x;
			Camera.ViewTo[1] += ViewVector.y;
			Camera.ViewTo[2] += ViewVector.z;
		}
	}
}
