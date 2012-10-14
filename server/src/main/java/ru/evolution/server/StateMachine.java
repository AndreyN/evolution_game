package ru.evolution.server;

import java.util.List;
import java.util.Random;

import ru.evolution.core.Card;
import ru.evolution.core.NotEnoughCardsException;
import ru.evolution.core.PackCards;
import ru.evolution.core.Player;
import ru.evolution.core.PlayerCard;
import ru.evolution.server.state.FeedingState;
import ru.evolution.server.state.GrowState;
import ru.evolution.server.state.IGameState;

public class StateMachine {
	private List<Player> players;
	private PackCards m_pack = null;
	private IGameState state;
	private int m_food;
	private Player activePlayer;

	public List<Player> getPlayers() {
		return players;
	}
	
	public PackCards getPack() {
		return m_pack;
	}

	public StateMachine(List<Player> players, PackCards pack) throws NotEnoughCardsException {
		this.players = players;
		m_pack = pack;
		// раздаем по 6 карт
		firstDealing(6);
		state = new GrowState();
	}
	
	public void nextState() {
		if(state instanceof FeedingState) {
			// фаза вымирания;
			// получения новых карт
			dealing();
			state = new GrowState();
		} else if(state instanceof GrowState) {
			// определение кормовой базы;
			toFeedingStage();
			state = new FeedingState();
		}
	}
	
	protected void dying() {
		;
	}
	
	/**
	 * Первый ход
	 * @throws Exception 
	 */
	protected void firstDealing(int numberOfCardsForStart) throws NotEnoughCardsException {
		for(int i = 0; i < numberOfCardsForStart; i++)
			for(Player player: getPlayers()) {
				Card card = m_pack.next();
				if(card == null)
					throw new NotEnoughCardsException();
				player.addCard(new PlayerCard(card));
			}
	}
	
	protected void dealing() {
		boolean toContinue = true;
		for(int i = 0; toContinue; i++)
			for(Player player: getPlayers()) {
				if(player.getCreatures().size() + 1 > i) {
					Card card = m_pack.next();
					if(card == null)
						toContinue = false;
					else
						player.addCard(new PlayerCard(card));
				}
			}
	}
	
	/**
	 * Метод возвращает оставшееся кол-во пищи
	 * @return
	 */
	public int getFoodCount() {
		return m_food;
	}
	
	public void takeFood() {
		m_food--;
	}
	
	/**
	 * Метод устанавливает кол-во пищи в этот ход
	 */
	public void toFeedingStage() {
		switch(players.size()) {
			case 2: {
				m_food = new Random().nextInt(6)+3;
				break;
			}
			case 3: {
				m_food = new Random().nextInt(6)+new Random().nextInt(6)+2;
				break;
			}
			case 4: {
				m_food = new Random().nextInt(6)+new Random().nextInt(6)+4;
				break;
			}
			default:
				m_food = 0;
		}
	}
	
	/**
	 * Метод возвращает среднее кол-во пищи за ход (для AI)
	 * @return
	 */
	public double getAverageFoodCount() {
		switch(players.size()) {
			case 2:	return 5.5;
			case 3: return 7;
			case 4: return 9;
			default: return 0;
		}
	}
}
