package ru.evolution.desktop;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import ru.evolution.client.IPlayerCardsRender;
import ru.evolution.client.model.Evolution;
import ru.evolution.core.PlayerCard;
import ru.evolution.desktop.cardarea.PlayerCardArea;

/**
 * Отображает имеющиеся у игрока карты
 * @author RaTor
 *
 */
public class PlayerCardsPanel extends JPanel implements IPlayerCardsRender {
	/**
	 * Модель
	 */
	private Evolution model;
	
	/**
	 * Список имеющихся у игрока карт
	 */
	private List<PlayerCardArea> renderedCards = null;
	
	/**
	 * Выбранная карта
	 */
	private SelectedCard selectedCard;
	
	/**
	 * Относительное расстояние между картами
	 */
	private double rangeBetweenCardsX;
	
	/**
	 * Высота
	 */
	private int height;
	
	public PlayerCardsPanel(Evolution model, double rangeBetweenCardsX, int cardHeight) {
		this.model = model;
		this.rangeBetweenCardsX = rangeBetweenCardsX;
		this.height = cardHeight;
		
		loadModel();
	}
	
	/**
	 * Возвращает все имеющиеся карты
	 * @return
	 */
	public List<PlayerCardArea> getRenderedCards() {
		return renderedCards;
	}
	
	public void loadModel() {
		renderedCards = new ArrayList<PlayerCardArea>();
		PlayerCardArea cardArea = null;
		int width = 0;
		for(PlayerCard card: model.getCards()) {
			if(cardArea == null) {
				cardArea = new PlayerCardArea(card, 0, 0, height);
				width = (int) (cardArea.width*rangeBetweenCardsX);
			} else
				cardArea = new PlayerCardArea(card, cardArea.x + width, 0, cardArea.height);
			renderedCards.add(cardArea);
		}
	}
	
	/**
	 * Метод устанавливает высоту панели равной выбранной пользователем
	 */
	public void updateHeight() {
		height = getHeight();
		for(PlayerCardArea ca: renderedCards)
			ca.setHeight(getHeight());
		updateRangeBetweenCards(rangeBetweenCardsX);
	}
	
	/**
	 * Метод обновляет расстояние между картами после выбора высоты
	 * @param rangeBetweenCards
	 */
	public void updateRangeBetweenCards(double rangeBetweenCards) {
		this.rangeBetweenCardsX = rangeBetweenCards;
		PlayerCardArea cardArea = null;
		int width = 0;
		for(int i = 0; i < renderedCards.size(); i++) {
			PlayerCardArea ca = renderedCards.get(i);
			if(cardArea == null) {
				cardArea = ca;
				width = (int) (cardArea.width*rangeBetweenCards);
			} else {
				ca.x = cardArea.x + width;
				cardArea = ca;
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < renderedCards.size(); i++) {
			PlayerCardArea ca = renderedCards.get(i);
			if(selectedCard == null || !ca.equals(selectedCard.cardArea))
				ca.render(g);
		}
		if(selectedCard != null) {
			selectedCard.cardArea.render(g);
		}
	}
	
	/**
	 * Обратный порядок перебора, сверху последняя карта
	 * @param p
	 * @return
	 */
	protected SelectedCard getCard(Point p) {
		int size = renderedCards.size();
		for(int i = size-1; i>=0; i--) {
			PlayerCardArea ca = renderedCards.get(i);
			if(ca.contains(p))
				return new SelectedCard(ca, ca.x - p.x, ca.y - p.y);
		}
		return null;
	}

	public void mouseDragged(MouseEvent e) {
		if(selectedCard == null)
			return;

		selectedCard.cardArea.x = selectedCard.offcetX + e.getX();
		selectedCard.cardArea.y = selectedCard.offcetY + e.getY();

		repaint();
	}
	
	public SelectedCard getSelectedCard() {
		return selectedCard;
	}

	public void mousePressed(MouseEvent e) {
		selectedCard = getCard(e.getPoint());
		if(selectedCard != null) {
			repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {
		if(selectedCard == null)
			return;
		selectedCard.cardArea.y = 0;
		selectedCard = null;
		repaint();
	}
	
	public boolean isEventInside(Point p) {
		return (getHeight() > p.getY());
	}

	public void removeCard(PlayerCard card) {
		loadModel();
	}

	public void addCard(PlayerCard card) {
		loadModel();
	}
}