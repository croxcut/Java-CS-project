package com.java.main.components;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import com.java.main.components.HomePage.HomePage;
import com.java.main.components.navigation.NavBar;
import com.java.main.graphics.WindowManager;
import com.java.main.utility.SharedConstants;

public class Home implements Runnable{

	private WindowManager windowManager = new WindowManager(SharedConstants.TITLE);
	private HomePage homepage = new HomePage(SharedConstants.SCREEN_WIDTH, SharedConstants.SCREEN_HEIGHT);
	
	private NavBar navBar = new NavBar(50, SharedConstants.SCREEN_HEIGHT);
	
	public Home() {
		
	}
	
	public void start() {
		new Thread(this).start();
		SwingUtilities.invokeLater(this);
	}

	private void init() {
		windowManager.createWindow(SharedConstants.SCREEN_WIDTH, SharedConstants.SCREEN_HEIGHT);
		windowManager.add(navBar);
		
		homepage.initialize();
		
		windowManager.add(homepage);
		
	}
	
	/**
			windowManager.remove(homepage);
            windowManager.revalidate();
            windowManager.repaint();
	 */
	
	@Override
	public void run() {
		init();
	}
	
}
