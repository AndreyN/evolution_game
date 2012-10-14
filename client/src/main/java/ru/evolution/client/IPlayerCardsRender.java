package ru.evolution.client;

import java.awt.event.MouseMotionListener;

import ru.evolution.core.PlayerCard;

/**
 * Интерфейс с событиями области карт, которые должна обрабатывать графическая подсистема
 * @author RaTor
 *
 */
public interface IPlayerCardsRender {
	public void removeCard(PlayerCard card);
	public void addCard(PlayerCard card);
	
	/**
	 * Загрузка модели
	 */
	public void loadModel();
}
