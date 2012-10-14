package ru.evolution.core;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String m_name;
	private List<Creature> m_creatures = new ArrayList<Creature>();
	private List<PlayerCard> m_cards = new ArrayList<PlayerCard>();
	
	public Player(String name) {
		m_name = name;
	}
	
	public void addCard(PlayerCard card) {
		m_cards.add(card);
	}
	
	public List<PlayerCard> getCards() {
		return m_cards;
	}
	
	public List<Creature> getCreatures() {
		return m_creatures;
	}
	
	public void createCreature(PlayerCard card) {
		m_creatures.add(new Creature(card));
		m_cards.remove(card);
	}
	
	public void removeCreature(Creature c) {
		m_creatures.remove(c);
	}
	
	public void addAbilityToCreature(Creature c, PlayerCard card) {
		new CreatureTrait(card, c);
		m_cards.remove(card);
	}
	
	public void addAbilityToCreatures(Creature c1, Creature c2, PlayerCard card) {
		new CreatureTrait(card, c1, c2);
		m_cards.remove(card);
	}
	
	public boolean canAddAbilityToCreature(Creature c, Ability a) {
		if(!a.isSingle())
			return false;
		return a.equals(Ability.FAT_ISSUE) || !c.hasAbility(a);
	}
	
	public boolean canAddAbilityToCreatures(Creature c1, Creature c2, Ability a) {
		if(a.isSingle())
			return false;
		return !c1.hasCommonAbility(a, c2);
	}
	
	/*public void getAvailableMethods(Stage stage) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Player.class.getMethod("createCreature", Card.class).invoke(this, null);
	}*/
	
	/**
	 * Method returns available turns for player
	 */
	/*public void getAvailableTurnsForCreature(FoodStage fs, Creature creature) {
		;
	}*/

}
