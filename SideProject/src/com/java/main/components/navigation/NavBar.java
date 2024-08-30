package com.java.main.components.navigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class NavBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int originalWidth;
    private int height;
    private int hoverWidth = 200; 
    private boolean hovered = false;

    public NavBar(int width, int height) {
        this.originalWidth = width;
        this.height = height;

        setOpaque(false);
        setSize(new Dimension(originalWidth, height));
        setPreferredSize(new Dimension(originalWidth, height));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                expandWidth();
                hovered = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
            	collapseWidth();
            }
        });
    }

    private void expandWidth() {
        setSize(new Dimension(hoverWidth, height));
        setPreferredSize(new Dimension(hoverWidth, height));
        revalidate(); 
        repaint(); 
    }

    private void collapseWidth() {
        setSize(new Dimension(originalWidth, height));
        setPreferredSize(new Dimension(originalWidth, height));
        revalidate(); 
        repaint(); 
    }

    public void initialize() {
    	// TODO: initialize components
    	
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(hovered) {
            g2.setColor(new Color(0, 0, 0, 120));
        } else {
        	g2.setColor(new Color(0, 0, 0, 0));
        }

        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));

        super.paintComponent(g2);
    }
}