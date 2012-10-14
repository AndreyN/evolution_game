package ru.evolution.core;

public enum Ability {
	CARNIVOROUS			(true, 1, true),
	SWIMMING			(true, 0, true),
	PIRACY				(true, 0, true),
	RUNNING				(true, 0, true),
	MIMICRY				(true, 0, true),
	SCAVANGER			(true, 0, true),
	SYMBIOSYS			(true, 0, false),
	SYMBIOSYS_SYMBIONT	(true, 0, false),
	TAIL_LOSS			(true, 0, true),
	COMMUNICATION		(true, 0, false),
	GRAZING				(true, 0, true),
	HIGH_BODY_WEIGHT	(true, 1, true),
	HIBRENATION_ABILITY	(true, 0, true),
	POISONOUS			(true, 0, true),
	COOPERATION			(true, 0, false),
	BURROWING			(true, 0, true),
	CAMOUFLAGE			(true, 0, true),
	SHARP_VISION		(true, 0, true),
	FAT_ISSUE			(true, 0, true),
	PARASITE			(false, 2, true);
	
	private boolean isFriendly;
	private int foodRequired;
	private boolean isSingle;
	
	Ability(boolean isFriendly, int foodRequired, boolean isSingle) {
		this.isFriendly = isFriendly;
		this.foodRequired = foodRequired;
		this.isSingle = isSingle;
	}
	
	public boolean isFriendly() {
		return isFriendly;
	}
	
	public boolean isSingle() {
		return isSingle;
	}
	
	public int getRequiredFood() {
		return foodRequired;
	}
}
