package ru.evolution.server.state;

public class FoodState implements IGameState {
	public int m_food = 5;
	
	public FoodState(int food) {
		m_food = food;
	}
}
