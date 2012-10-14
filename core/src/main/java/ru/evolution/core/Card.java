package ru.evolution.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Карта, описывает возможные способности
 * @author RaTor
 *
 */
public class Card {
	private List<Ability> abilities;
	
	/**
	 * Тип карты (т.е. какие свойства она предоставляет), служит для получения пути к рисунку
	 */
	private String typeId;
	
	public List<Ability> getAbilities() {
		return abilities;
	}
	
	public String getTypeId() {
		return typeId;
	}
	
	public Card(String typeId, Ability ability) {
		this.typeId = typeId;
		abilities = new ArrayList<Ability>();
		abilities.add(ability);
	}
	
	public Card(String typeId, Ability ability1, Ability ability2) {
		this(typeId, ability1);
		abilities.add(ability2);
	}
}