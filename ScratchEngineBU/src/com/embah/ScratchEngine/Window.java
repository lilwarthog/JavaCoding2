package com.embah.ScratchEngine;

import java.awt.Toolkit;

import javax.swing.JFrame;

import com.embah.ScratchEngine.Drawing.Painter;

public class Window extends JFrame{
	private Screen screen;
	
	public Window(){
		screen = new Screen();
		add(screen);
		setUndecorated(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
	}
	
	public Window(Painter[] p){
		screen = new Screen();
		for(Painter painter : p){
			screen.addPainter(painter);
		}
		add(screen);
		setUndecorated(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		screen.repaint();
	}
}
