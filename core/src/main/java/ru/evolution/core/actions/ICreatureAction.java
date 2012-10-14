package ru.evolution.core.actions;

import ru.evolution.core.Creature;

public interface ICreatureAction {
	public void doAction(Creature fromCreature, Creature toCreature);
	public boolean canDoAction(Creature fromCreature, Creature toCreature);
}
