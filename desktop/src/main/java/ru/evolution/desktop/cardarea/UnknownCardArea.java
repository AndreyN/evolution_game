package ru.evolution.desktop.cardarea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.PathIterator;

public class UnknownCardArea extends AbstractCardArea {
	public UnknownCardArea(int x, int y, int height) {
    	super("unknown", x, y, height);

    	AffineTransform at = new AffineTransform();
    	PathIterator pi = getPathIterator(at);
    	while(!pi.isDone()) {
    		float[] coords = new float[2];
    		int cs = pi.currentSegment(coords);
    		//System.out.println(cs);
    		String s = "";
    		for(float xx: coords)
    			s+=xx+",";
    		//System.out.println(s);
    		//System.out.println(pi.getWindingRule());
    		pi.next();
    	}
    	//System.out.println("end");
    }
	
	public void render(Graphics g) {
		g.drawImage(getImage(), x, y, width, height, null);
	}
	
	public void render(Graphics g, int screenHeight) {
		g.drawImage(getImage(), x, screenHeight-y-height, width, height, null);
	}
}