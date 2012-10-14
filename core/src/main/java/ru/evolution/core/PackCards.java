package ru.evolution.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Колода карт
 * @author RaTor
 *
 */
public class PackCards implements Iterator<Card> {
	private List<Card> m_initialCards = null;
	private List<Card> m_orderedCards = null;
	private Iterator<Card> m_iterator = null;
	private int m_count;
	
	/**
	 * Создает стандартный набор карт
	 */
	public PackCards() {
		m_initialCards = new ArrayList<Card>();
		for(int i = 0; i < 4; i++) {
			m_initialCards.add(new Card("GRAZING_AND_FAT_ISSUE", Ability.GRAZING, Ability.FAT_ISSUE));
			m_initialCards.add(new Card("PARASITE_AND_FAT_ISSUE", Ability.PARASITE, Ability.FAT_ISSUE));
			m_initialCards.add(new Card("PARASITE_AND_CARNIVOROUS", Ability.PARASITE, Ability.CARNIVOROUS));
			m_initialCards.add(new Card("COOPERATION_AND_CARNIVOROUS", Ability.COOPERATION, Ability.CARNIVOROUS));
			m_initialCards.add(new Card("COOPERATION_AND_FAT_ISSUE", Ability.COOPERATION, Ability.FAT_ISSUE));
			m_initialCards.add(new Card("COMMUNICATION_AND_CARNIVOROUS", Ability.COMMUNICATION, Ability.CARNIVOROUS));
			m_initialCards.add(new Card("CAMOUFLAGE_AND_FAT_ISSUE", Ability.CAMOUFLAGE, Ability.FAT_ISSUE));
			m_initialCards.add(new Card("POISONOUS_AND_CARNIVOROUS", Ability.POISONOUS, Ability.CARNIVOROUS));
			m_initialCards.add(new Card("SHARP_VISION_AND_FAT_ISSUE", Ability.SHARP_VISION, Ability.FAT_ISSUE));
			m_initialCards.add(new Card("HIGH_BODY_WEIGHT_AND_CARNIVOROUS", Ability.HIGH_BODY_WEIGHT, Ability.CARNIVOROUS));
			m_initialCards.add(new Card("HIGH_BODY_WEIGHT_AND_FAT_ISSUE", Ability.HIGH_BODY_WEIGHT, Ability.FAT_ISSUE));
			m_initialCards.add(new Card("HIBRENATION_ABILITY_AND_CARNIVOROUS", Ability.HIBRENATION_ABILITY, Ability.CARNIVOROUS));
			m_initialCards.add(new Card("MIMICRY", Ability.MIMICRY));
			m_initialCards.add(new Card("SYMBIOSYS", Ability.SYMBIOSYS, Ability.SYMBIOSYS_SYMBIONT));
			m_initialCards.add(new Card("BURROWING_AND_FAT_ISSUE", Ability.BURROWING, Ability.FAT_ISSUE));
			m_initialCards.add(new Card("SCAVANGER", Ability.SCAVANGER));
			m_initialCards.add(new Card("PIRACY", Ability.PIRACY));
			m_initialCards.add(new Card("TAIL_LOSS", Ability.TAIL_LOSS));
			m_initialCards.add(new Card("RUNNING", Ability.RUNNING));
			m_initialCards.add(new Card("SWIMMING", Ability.SWIMMING));
			m_initialCards.add(new Card("SWIMMING", Ability.SWIMMING));
		}
		shuffle();
	}
	
	/**
	 * Создается колода на основе заданного набора карт
	 * @param cards
	 */
	public PackCards(List<Card> cards) {
		m_initialCards = new ArrayList<Card>(cards);
		shuffle();
	}
	
	/**
	 * Возвращает начальный набор карт
	 * @return
	 */
	public List<Card> getInitialCards() {
		return Collections.unmodifiableList(m_initialCards);
	}
	
	/**
	 * Метод перетасовывает карты. 
	 */
	protected void shuffle() {
		m_orderedCards = new ArrayList<Card>(m_initialCards);
		//m_orderedCards = new ArrayList<Card>(m_initialCards.size());
		// создаем новые карты, чтобы их статус был скрыт
		/*for(Card card: m_initialCards)
			m_orderedCards.add(new Card(card.getAbilities()));*/
		Collections.shuffle(m_orderedCards);
		m_iterator = m_orderedCards.iterator();
		m_count = m_orderedCards.size();
	}

	public boolean hasNext() {
		return m_iterator.hasNext();
	}

	public Card next() {
		m_count--;
		return m_iterator.next();
	}

	public void remove() {
		m_iterator.remove();
	}
	
	/**
	 * Число оставшихся карт в колоде (для AI)
	 * @return
	 */
	public int getCount() {
		return m_count;
	}
}
