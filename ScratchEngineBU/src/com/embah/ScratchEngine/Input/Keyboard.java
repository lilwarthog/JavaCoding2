package com.embah.ScratchEngine.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.embah.ScratchEngine.Camera;

public class Keyboard implements KeyListener{
	private static boolean keys[] = new boolean[10];
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keys[0] = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keys[1] = true;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			keys[2] = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keys[3] = true;
		if(e.getKeyCode() == KeyEvent.VK_W)
			keys[4] = true;
		if(e.getKeyCode() == KeyEvent.VK_A)
			keys[5] = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			keys[6] = true;
		if(e.getKeyCode() == KeyEvent.VK_D)
			keys[7] = true;
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keys[0] = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keys[1] = false;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			keys[2] = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keys[3] = false;
		if(e.getKeyCode() == KeyEvent.VK_W)
			keys[4] = false;
		if(e.getKeyCode() == KeyEvent.VK_A)
			keys[5] = false;
		if(e.getKeyCode() == KeyEvent.VK_S)
			keys[6] = false;
		if(e.getKeyCode() == KeyEvent.VK_D)
			keys[7] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public static boolean[] getKeys(){
		return keys;
	}
}
