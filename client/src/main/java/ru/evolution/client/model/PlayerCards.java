package ru.evolution.client.model;

import java.util.ArrayList;
import java.util.List;

import ru.evolution.client.ICreaturesRender;
import ru.evolution.client.IPlayerCardsRender;
import ru.evolution.core.PlayerCard;

public class PlayerCards {
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
	
	public PlayerCards(List<PlayerCard> cards, List<Creature> creatureModels) {
		this.cards = cards;
		this.creatureModels = creatureModels;
	}
	
	public void moveSelectedCardToPlayerArea() {
		getPlayerCardsRender().returnSelectedCard();
	}
	
	public void moveSelectedCardToCreatureArea() {
		getCreaturesRender().addSelectedCard(cards.get(selectedCardPosition));
	}
	
	public void removeSelectedCard() {
		selectedCardPosition = null;
		getPlayerCardsRender().removeSelectedCard();
	}
	
	public void removeCard(PlayerCard card) {
		getPlayerCardsRender().removeCard(card);
	}
	
	public void addCard(PlayerCard card) {
		getPlayerCardsRender().addCard(card);
	}

	public Integer getSelectedCard() {
		return selectedCardPosition;
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