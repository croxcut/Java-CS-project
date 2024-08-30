package com.java.main.graphics;

import javax.swing.JFrame;

public class WindowManager extends JFrame{

	public WindowManager(String title) {
		super(title);
	}
	
	public void createWindow(int width, int height) {
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
