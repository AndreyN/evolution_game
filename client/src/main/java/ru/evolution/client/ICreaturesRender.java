package ru.evolution.client;


/**
 * Интерфейс с событиями области созданий, которые должна обрабатывать графическая подсистема
 * @author RaTor
 *
 */
public interface ICreaturesRender {
	/**
	 * Создание нового животного
	 */
	public void addCreature();
	public void removeCreature();
	public void loadModel();
}
