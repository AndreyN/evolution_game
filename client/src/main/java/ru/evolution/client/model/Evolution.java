package ru.evolution.client.model;

import java.util.ArrayList;
import java.util.List;

import ru.evolution.client.ICreaturesRender;
import ru.evolution.client.IPlayerCardsRender;
import ru.evolution.core.PlayerCard;

public class Evolution {
	private List<PlayerCard> cards = new ArrayList<PlayerCard>();
	private List<Creature> creatureModels = new ArrayList<Creature>();
	private Integer selectedCardPosition;
	private IPlayerCardsRender playerCardsRender;
	private ICreaturesRender creaturesRender;
	
	public List<PlayerCard> getCards() {
		return cards;
	}
	
	public List<Creature> getCreatureModels() {
		return creatureModels;
	}
	
	public Evolution(List<PlayerCard> cards, List<Creature> creatureModels) {
		this.cards = cards;
		this.creatureModels = creatureModels;
	}
	
	public void removeCard(PlayerCard card) {
		getPlayerCardsRender().removeCard(card);
	}
	
	public void addCard(PlayerCard card) {
		getPlayerCardsRender().addCard(card);
	}

	public PlayerCard getSelectedCard() {
		return cards.get(selectedCardPosition);
	}
	
	/**
	 * Событие выбора карты
	 * @param cardPosition
	 */
	public void setSelectedCardFromRender(Integer cardPosition) {
		selectedCardPosition = cardPosition;
	}

	public void setPlayerCardsRender(IPlayerCardsRender render) {
		this.playerCardsRender = render;
	}

	public IPlayerCardsRender getPlayerCardsRender() {
		return playerCardsRender;
	}

	public void setCreaturesRender(ICreaturesRender creaturesRender) {
		this.creaturesRender = creaturesRender;
	}

	public ICreaturesRender getCreaturesRender() {
		return creaturesRender;
	}
}