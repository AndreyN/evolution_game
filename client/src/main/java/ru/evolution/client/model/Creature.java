package ru.evolution.client.model;

import java.util.ArrayList;
import java.util.List;

import ru.evolution.core.CreatureTrait;

public class Creature {
	public ru.evolution.core.Creature creature;
	public List<CreatureTrait> abilities = new ArrayList<CreatureTrait>();
}