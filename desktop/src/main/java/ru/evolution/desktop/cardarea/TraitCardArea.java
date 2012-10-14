package ru.evolution.desktop.cardarea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;

import ru.evolution.core.CreatureTrait;

public class TraitCardArea extends AbstractCardArea {
	private CreatureTrait playerCard;
	
	public TraitCardArea(CreatureTrait card, int x, int y, int height) {
    	super(card.getCard().getTypeId(), x, y, height);
    	playerCard = card;
    }
	
	/**
	 * Предполагается, что у нас только 2 ability у карты
	 * @param g
	 */
	public void render(Graphics g) {
		if(playerCard.getCard().getAbilities().indexOf(playerCard.getAbility()) == 0) {
			//g.drawImage(getImage(), x, y, width, height, null);
			Graphics2D g2 = (Graphics2D) g;
			AffineTransform at = new AffineTransform();
			try {
				at.createInverse();
			} catch (NoninvertibleTransformException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			at.rotate(Math.PI, (x+width)/2, (y+height)/2);
			at.scale((double) width/getImage().getWidth(null), (double) width/getImage().getWidth(null));
			g2.drawImage(getImage(), at, null);
		} else {
			//long t = System.currentTimeMillis();
			Graphics2D g2 = (Graphics2D) g;
			AffineTransform at = new AffineTransform();
			at.rotate(Math.PI, (x+width)/2, (y+height)/2);
			g2.drawImage(getImage(), at, null);
			/*g2.rotate(Math.PI, m_cardArea.x+width/2, m_cardArea.y+height/2);
			g.drawImage(getImage(), m_cardArea.x, m_cardArea.y, width, height, null);
			g2.rotate(-Math.PI, m_cardArea.x+width/2, m_cardArea.y+height/2);
			System.out.println(System.currentTimeMillis()-t);*/
		}
	}
	
	public void render(Graphics g, int screenHeight) {
		g.drawImage(getImage(), x, screenHeight-y-height, width, height, null);
	}
}