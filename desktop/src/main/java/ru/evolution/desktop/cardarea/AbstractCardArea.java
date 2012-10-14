package ru.evolution.desktop.cardarea;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.ImageIcon;

public abstract class AbstractCardArea extends Rectangle implements Shape {
	private ImageIcon imageIcon;
	
	/**
	 * Оригинальная высота рисунка
	 */
	public static final int DEFAULT_HEIGHT = 212;
	
	/**
	 * Оригинальная ширина рисунка
	 */
	public static final int DEFAULT_WIDTH = 145;
	/**
	 * Определяет, прорисовывать или нет область
	 */
	private boolean isVisible = true;
	
	public AbstractCardArea(String typeId, int x, int y, int height) {
    	super(x, y, 0, height);
		imageIcon = new ImageIcon("src\\main\\resources\\images\\" + typeId.toLowerCase() + ".png");
		setHeight(height);
    }
	
	public void setHeight(int height) {
		if(height == 0) {
			this.height = imageIcon.getIconHeight();
			width = imageIcon.getIconWidth();
		} else {
			this.height = height;
			width = height*imageIcon.getIconWidth()/imageIcon.getIconHeight();
		}
	}
	
	public void setVisible(boolean visible) {
		isVisible = visible;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	protected Image getImage() {
		return imageIcon.getImage();
	}
	
	public abstract void render(Graphics g);
	
	/**
	 * Отрисовка изображения на экране с заданными высотой и шириной
	 * @param g
	 * @param width
	 * @param height
	 */
	public void render(Graphics g, int screenHeight) {
		render(g);
	}
}