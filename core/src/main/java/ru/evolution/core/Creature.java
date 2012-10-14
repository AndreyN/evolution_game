package ru.evolution.core;

import java.util.ArrayList;
import java.util.List;

public class Creature {
	private Card m_baseCard;
	public int m_food;
	public int m_requiredFood;
	private List<CreatureTrait> m_abilities = new ArrayList<CreatureTrait>();
	private boolean m_isCanPirate;
	private boolean m_isCarnivorous;
	
	public Creature(PlayerCard baseCard) {
		m_baseCard = baseCard.getCard();
	}
	
	public Card getBaseCard() {
		return m_baseCard;
	}
	
	public boolean hasAbility(Ability a) {
		for(CreatureTrait ca: m_abilities)
			if(ca.getAbility().equals(a))
				return true;
		return false;
	}
	
	public boolean hasCommonAbility(Ability a, Creature c) {
		for(CreatureTrait ca: m_abilities)
			if(ca.getAbility().equals(a) && ca.isInCreature(c))
				return true;
		return false;
	}
	
	public List<CreatureTrait> getAbilities() {
		return m_abilities;
	}
	
	/**
	 * Удаление свойства животного.
	 * Проверка, у кого ещё нужно удалять, и само удаление проходят в CreatureAbility. 
	 * @param ca
	 */
	public void removeAbility(CreatureTrait ca) {
		ca.remove();
	}
	
	public void removeAbilityFromList(CreatureTrait ca) {
		m_abilities.remove(ca);
	}
	
	public void addAbility(CreatureTrait ca) {
		m_abilities.add(ca);
	}
	
	/*public void eatFood(StateMachine state) {
		state.takeFood();
		eat();
	}
	
	public void eatFoodToFat(StateMachine state) {
		state.takeFood();
		eat();
	}
	
	public void eatCreature(StateMachine state, Creature creature) {
		for(Player player : state.getPlayers())
			if(player.getCreatures().contains(creature)) {
				player.removeCreature(creature);
				break;
			}
		eat();
		eat();
	}*/
	
	public void pirate(Creature creature) {
		creature.takeFood();
		eat();
	}
	
	public boolean isCanPirate() {
		return m_isCanPirate;
	}
	
	public void setCanPirate(boolean isCanPirate) {
		m_isCanPirate = isCanPirate;
	}
	
	public boolean isCarnivorous() {
		return m_isCarnivorous;
	}
	
	public void setCarnivorous(boolean isCarnivorous) {
		m_isCarnivorous = isCarnivorous;
	}
	
	public void takeFood() {
		m_food--;
	}
	
	private void eat() {
		m_food++;
	}
	
	/**
	 * Метод показывает, сколько еды требуется созданию
	 * @return
	 */
	public int getRequiredFood() {
		return m_requiredFood;
	}
	
	/**
	 * Метод показывает, сколько еды есть у создания
	 * @return
	 */
	public int getFood() {
		return m_food;
	}
	
	public void setFood(int food) {
		m_food = food;
	}
	
	public void setRequiredFood(int food) {
		m_requiredFood = food;
	}
}
