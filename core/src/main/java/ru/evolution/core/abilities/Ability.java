package ru.evolution.core.abilities;

import java.util.List;

import ru.evolution.core.actions.ICreatureAction;

public abstract class Ability {
	public abstract String getName();
	public abstract boolean isFriendly();	
	public abstract boolean isSingle();	
	public abstract int getRequiredFood();
	public abstract List<ICreatureAction> getAvailableActions();
}
