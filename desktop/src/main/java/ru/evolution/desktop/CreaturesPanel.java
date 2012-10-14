package ru.evolution.desktop;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import ru.evolution.client.ICreaturesRender;
import ru.evolution.client.model.Creature;
import ru.evolution.client.model.Evolution;
import ru.evolution.desktop.cardarea.PlayerCardArea;

public class CreaturesPanel extends JPanel implements ICreaturesRender {
	private Evolution model;
	private List<CreatureArea> m_renderedCreatures = new ArrayList<CreatureArea>();
	/**
	 * Выбранная карта
	 */
	private SelectedCard selectedCard;
	
	/**
	 * Относительное расстояние между картами
	 */
	private double rangeBetweenCardsX;
	
	/**
	 * Относительное расстояние между картами
	 */
	private double rangeBetweenCardsY;
	private int offsetBetweenCreaturesX;
	private int cardHeight;
	
	public CreaturesPanel(Evolution model, double rangeBetweenCardsX, double rangeBetweenCardsY, int offsetBetweenCreaturesX, int cardHeight) {
		this.model = model;
		this.rangeBetweenCardsX = rangeBetweenCardsX;
		this.rangeBetweenCardsY = rangeBetweenCardsY;
		this.offsetBetweenCreaturesX = offsetBetweenCreaturesX;
		this.cardHeight = cardHeight;
		
		loadModel();
	}
	
	public void loadModel() {
		CreatureArea creature = null;
		for(Creature creatureModel: model.getCreatureModels()) {
			if(creature == null)
				creature = new CreatureArea(creatureModel, 0, 0, rangeBetweenCardsX, rangeBetweenCardsY, cardHeight);
			else
				creature = new CreatureArea(creatureModel, creature.x + creature.width + offsetBetweenCreaturesX, getHeight(), rangeBetweenCardsX, rangeBetweenCardsY, cardHeight);
			m_renderedCreatures.add(creature);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		long t = System.currentTimeMillis();
		for(int i = 0; i < m_renderedCreatures.size(); i++)
			m_renderedCreatures.get(i).render(g, getHeight());
		if(selectedCard != null)
			selectedCard.cardArea.render(g);
		//System.out.println(System.currentTimeMillis() - t);
	}
	
	public void mousePressed(MouseEvent e, SelectedCard selectedPlayerCard) {
		PlayerCardArea cardArea = new PlayerCardArea(selectedPlayerCard.cardArea.getCard(), selectedPlayerCard.cardArea.x, -selectedPlayerCard.cardArea.height, selectedPlayerCard.cardArea.height);
		selectedCard = new SelectedCard(cardArea, cardArea.x - e.getX(), cardArea.y - e.getY());
		repaint();
	}
	
	public void mouseReleased(MouseEvent e) {
		//System.out.println(e.getComponent().equals(this));
		if(selectedCard == null)
			return;
		for(CreatureArea ca: m_renderedCreatures)
			if(ca.intersects(selectedCard.cardArea)) {
				System.out.println("inter");
				break;
			}
		System.out.println("outer");
		selectedCard = null;
		//repaint();Collections.unmodifiableCollection(c)
	}

	public void mouseDragged(MouseEvent e) {
		selectedCard.cardArea.x = selectedCard.offcetX + e.getX();
		selectedCard.cardArea.y = selectedCard.offcetY + e.getY();
		
		repaint();
	}

	public void addCreature() {
		// TODO Auto-generated method stub
		
	}

	public void removeCreature() {
		// TODO Auto-generated method stub
		
	}
}
