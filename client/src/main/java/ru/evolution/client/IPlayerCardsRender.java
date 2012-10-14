package ru.evolution.client;

import java.awt.event.MouseMotionListener;

import ru.evolution.core.PlayerCard;

/**
 * ��������� � ��������� ������� ����, ������� ������ ������������ ����������� ����������
 * @author RaTor
 *
 */
public interface IPlayerCardsRender {
	public void removeCard(PlayerCard card);
	public void addCard(PlayerCard card);
	
	/**
	 * �������� ������
	 */
	public void loadModel();
}
