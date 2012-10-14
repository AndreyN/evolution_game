package ru.evolution.desktop;

import ru.evolution.client.ISelectedCard;
import ru.evolution.desktop.cardarea.AbstractCardArea;
import ru.evolution.desktop.cardarea.PlayerCardArea;

/**
 * ��������� �����, �������� ���������� � �����, ��� �������
 * @author RaTor
 *
 */
public class SelectedCard implements ISelectedCard {
	public SelectedCard(PlayerCardArea ca, int offcetX, int offcetY) {
		this.offcetX = offcetX;
		this.offcetY = offcetY;
		this.cardArea = ca;
	}
	public PlayerCardArea cardArea;
	public int offcetX;
	public int offcetY;
}
