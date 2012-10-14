package ru.evolution.desktop;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import ru.evolution.client.model.Creature;
import ru.evolution.core.CreatureTrait;
import ru.evolution.desktop.cardarea.AbstractCardArea;
import ru.evolution.desktop.cardarea.PlayerCardArea;
import ru.evolution.desktop.cardarea.TraitCardArea;
import ru.evolution.desktop.cardarea.UnknownCardArea;

/**
 * Класс описывает область с животными
 * @author RaTor
 *
 */
public class CreatureArea implements Shape {
	private Creature model;
	private List<AbstractCardArea> renderedCards = new ArrayList<AbstractCardArea>();
	public int x = 0;
	public int y = 0;
	private double rangeBetweenCardsX;
	private double rangeBetweenCardsY;
	public int width = 0;
	public int height = 0;
	
	public CreatureArea(Creature creatureModel, int x, int y, double rangeBetweenCardsX, double rangeBetweenCardsY, int cardHeight) {
		model = creatureModel;
		this.rangeBetweenCardsX = rangeBetweenCardsX;
		this.rangeBetweenCardsY = rangeBetweenCardsY;
		this.x = x;
		this.y = y;

		AbstractCardArea cardArea = new UnknownCardArea(x, y, cardHeight);
		renderedCards.add(cardArea);
		int width = (int) (cardArea.width*rangeBetweenCardsX);
		int height = (int) (cardArea.height*rangeBetweenCardsY);
		for(CreatureTrait ca: model.abilities) {
			cardArea = new TraitCardArea(ca, cardArea.x + width, cardArea.y + height, cardHeight);
			renderedCards.add(cardArea);
		}
		this.width = cardArea.width + Math.abs(width)*(renderedCards.size() - 1);
		this.height = cardArea.height + Math.abs(height)*(renderedCards.size() - 1);
    }
	
	public void render(Graphics g, int screenHeight) {
		for(int i = 0; i < renderedCards.size(); i++) {
			AbstractCardArea ca = renderedCards.get(i);
			ca.render(g, screenHeight);
		}
	}

	public Rectangle getBounds() {
		int width = renderedCards.get(renderedCards.size()).x + renderedCards.get(renderedCards.size()).width;
		int height = renderedCards.get(renderedCards.size()).y + renderedCards.get(renderedCards.size()).height;
		return new Rectangle(x, y, width, height);
	}

	public Rectangle2D getBounds2D() {
		return null;
	}

	public boolean contains(double x, double y) {
		for(AbstractCardArea aca: renderedCards)
			if(aca.contains(x, y))
				return true;
		return false;
	}

	public boolean contains(Point2D p) {
		for(AbstractCardArea aca: renderedCards)
			if(aca.contains(p))
				return true;
		return false;
	}

	public boolean intersects(double x, double y, double w, double h) {
		for(AbstractCardArea aca: renderedCards)
			if(aca.intersects(x, y, w, h))
				return true;
		return false;
	}

	public boolean intersects(Rectangle2D r) {
		for(AbstractCardArea aca: renderedCards)
			if(aca.intersects(r))
				return true;
		return false;
	}

	public boolean contains(double x, double y, double w, double h) {
		return false;
	}

	public boolean contains(Rectangle2D r) {
		return false;
	}

	public PathIterator getPathIterator(AffineTransform at) {
		return null;
	}

	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return null;
	}
}
