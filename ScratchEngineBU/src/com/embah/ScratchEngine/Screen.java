package com.embah.ScratchEngine;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.embah.ScratchEngine.Drawing.Painter;
import com.embah.ScratchEngine.Drawing.Render;
import com.embah.ScratchEngine.Input.Keyboard;
import com.embah.ScratchEngine.Utilities.Time;

public class Screen extends JPanel{
	//ADD MOUSE LISTENER
	//Attach it to Object if possible and work with the polygons
	//.contains(Point p) in polygon class so you can easily check with that
	private Camera camera = new Camera();
	private ArrayList<Painter> painters = new ArrayList<Painter>();
	private Time time = new Time(this);
	private Keyboard keyboard = new Keyboard();
	private Render render = new Render();
	
	public Screen(){
		addKeyListener(keyboard);
		setFocusable(true);
		time.start();
		addPainter(render);
	}
	
	public void paintComponent(Graphics g){
		for(Painter p : painters){
			p.paint(g);
		}
	}
	
	public void addPainter(Painter painter){
		painters.add(painter);
	}
}

