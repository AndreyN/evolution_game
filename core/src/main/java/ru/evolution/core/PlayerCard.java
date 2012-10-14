package ru.evolution.core;

import java.util.List;

public class PlayerCard {
	private Card m_card;
	private Ability m_activeAbility;
	
	public PlayerCard(Card card) {
		m_card = card;
		m_activeAbility = card.getAbilities().get(0);
	}
	
	public Card getCard() {
		return m_card;
	}
	
	public List<Ability> getAbilities() {
		return m_card.getAbilities();
	}
	
	public Ability getActiveAbility() {
		return m_activeAbility;
	}
	
	public void setActiveAbility(Ability ability) {
		if(!m_card.getAbilities().contains(ability))
			throw new IllegalArgumentException("You must specify available ability");
		m_activeAbility = ability;
	}
	
	public boolean canChangeActiveAbility() {
		return m_card.getAbilities().size() > 1;
	}
	
	public void changeActiveAbility() {
		int index = m_card.getAbilities().indexOf(getActiveAbility());
		setActiveAbility(m_card.getAbilities().get((index + 1) % m_card.getAbilities().size()));
	}
}
