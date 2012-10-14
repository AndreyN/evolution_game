package ru.evolution.desktop;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image m_image;
	
	public ImagePanel(String imagePath) {
		m_image = new ImageIcon(imagePath).getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println(m_image.getHeight(this));
		//System.out.println(m_image.getWidth(this));
		g.drawImage(m_image, 0, 0, null);
	}
}
