package ru.evolution.core.actions;

import ru.evolution.core.Creature;

public class Hunt implements ICreatureAction {
	public void doAction(Creature fromCreature, Creature toCreature) {
		;//fromCreature.eatCreature(null, toCreature);
	}

	public boolean canDoAction(Creature fromCreature, Creature toCreature) {
		return true;
	}
}
