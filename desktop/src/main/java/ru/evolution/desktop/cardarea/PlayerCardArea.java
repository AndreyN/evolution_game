package ru.evolution.desktop.cardarea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import ru.evolution.core.PlayerCard;

public class PlayerCardArea extends AbstractCardArea {
	private PlayerCard playerCard;
	
	public PlayerCardArea(PlayerCard card, int x, int y, int height) {
    	super(card.getCard().getTypeId(), x, y, height);
    	playerCard = card;
    }
	
	public PlayerCard getCard() {
		return playerCard;
	}
	
	/**
	 * Предполагается, что у нас только 2 ability у карты
	 * @param g
	 */
	public void render(Graphics g) {
		if(isVisible())
			if(playerCard.getAbilities().indexOf(playerCard.getActiveAbility()) == 0)
				g.drawImage(getImage(), x, y, width, height, null);
			else {
				//long t = System.currentTimeMillis();
				Graphics2D g2 = (Graphics2D) g;
				AffineTransform at = new AffineTransform();
				at.rotate(Math.PI, (x+width)/2, (y+height)/2);
				at.scale((double) width/getImage().getWidth(null), (double) width/getImage().getWidth(null));
				g2.drawImage(getImage(), at, null);
				/*g2.rotate(Math.PI, m_cardArea.x+width/2, m_cardArea.y+height/2);
				g.drawImage(getImage(), m_cardArea.x, m_cardArea.y, width, height, null);
				g2.rotate(-Math.PI, m_cardArea.x+width/2, m_cardArea.y+height/2);
				System.out.println(System.currentTimeMillis()-t);*/
			}
	}
}