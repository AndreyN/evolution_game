package ru.evolution.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Карта выложенная как свойство животного.
 * Отвечает за добавление и удаление свойств животного (или животных, если накладывается на несколько животных)
 * @author RaTor
 *
 */
public class CreatureTrait {
	private PlayerCard card;
	private List<Creature> m_creatures;
	private boolean m_isCanBeUsed;
	
	public CreatureTrait(PlayerCard card, Creature creature) {
		this.card = card;
		m_creatures = new ArrayList<Creature>();
		m_creatures.add(creature);
		creature.addAbility(this);
	}
	
	public CreatureTrait(PlayerCard card, Creature creature1, Creature creature2) {
		this(card, creature1);
		m_creatures.add(creature2);
		creature2.addAbility(this);
	}
	
	public Card getCard() {
		return card.getCard();
	}
	
	public Ability getAbility() {
		return card.getActiveAbility();
	}
	
	/*public List<Creature> getCreatures() {
		return m_creatures;
	}*/
	
	public void remove() {
		for(Creature creature: m_creatures)
			creature.removeAbilityFromList(this);
	}
	
	public boolean isInCreature(Creature c) {
		return m_creatures.contains(c);
	}
	
	public boolean isCanBeUsed() {
		return m_isCanBeUsed;
	}
	
	public void setCanBeUsed(boolean isCanBeUsed) {
		m_isCanBeUsed = isCanBeUsed;
	}
}
