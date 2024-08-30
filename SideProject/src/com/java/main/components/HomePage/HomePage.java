package com.java.main.components.HomePage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HomePage extends JPanel{
	
	private BufferedImage image;
	
	public HomePage(int width, int height) {
		setOpaque(true);
		setSize(width, height);
		setBackground(new Color(0, 0, 0, 255));
	}
	
	public void initialize() {
		if(image == null) {
			try {
				image = ImageIO.read(new File("res/background/background.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	
	}
	
	
}
