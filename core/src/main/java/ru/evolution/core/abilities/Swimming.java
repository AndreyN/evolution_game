package ru.evolution.core.abilities;

import java.util.List;

import ru.evolution.core.actions.ICreatureAction;

public class Swimming extends Ability {
	@Override
	public boolean isFriendly() {
		return true;
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@Override
	public int getRequiredFood() {
		return 0;
	}

	@Override
	public List<ICreatureAction> getAvailableActions() {
		return null;
	}

	@Override
	public String getName() {
		return "SWIMMING";
	}
}
