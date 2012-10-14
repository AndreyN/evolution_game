package ru.evolution.server.ai;

import java.util.List;

public class FirstStageAI {
	/*public void getAvailableTurns(Player p, List<Player> players) {
		for(Card card: p.getCards()) {
			p.createCreature(card);
			System.out.println("create creature " + p.getCreatures().size());
			for(Ability a: card.getAbilities())
				if(a.isFriendly())
					if(a.isSingle()) {
						for(Creature c: p.getCreatures())
							if(p.canAddAbilityToCreature(c, a)) {
								p.addAbilityToCreature(c, card);
								System.out.println("add ability " + a.name() + " to creature " + p.getCreatures().indexOf(c));
							}
					}
					else {
						int size = p.getCreatures().size();
						for(int i = 0; i < size-1; i++)
							for(int j = i+1; j < size; j++) {
								Creature c1 = p.getCreatures().get(i);
								Creature c2 = p.getCreatures().get(j);
								if(p.canAddAbilityToCreatures(c1, c2, a)) {
									p.addAbilityToCreatures(c1, c2, card, a);
									System.out.println("add ability " + a.name() + " to creature " + p.getCreatures().indexOf(c1) + " and creature " + p.getCreatures().indexOf(c2));
								}
							}
					}
				else
					if(a.isSingle()) {
						for(Player enemy: players)
							if(!enemy.equals(p))
								for(Creature c: p.getCreatures())
									if(enemy.canAddAbilityToCreature(c, a)) {
										enemy.addAbilityToCreature(c, card, a);
										System.out.println("add ability " + a.name() + " to palyer" + players.indexOf(enemy) + " to creature " + p.getCreatures().indexOf(c));
									}
					}
					else {
						for(Player enemy: players)
							if(!enemy.equals(p)) {
								int size = enemy.getCreatures().size();
								for(int i = 0; i < size-1; i++)
									for(int j = i+1; j < size; j++) {
										Creature c1 = enemy.getCreatures().get(i);
										Creature c2 = enemy.getCreatures().get(j);
										if(enemy.canAddAbilityToCreatures(c1, c2, a)) {
											enemy.addAbilityToCreatures(c1, c2, card, a);
											System.out.println("add ability " + a.name() + " to palyer" + players.indexOf(enemy) + " to creature " + p.getCreatures().indexOf(c1) + " and creature " + p.getCreatures().indexOf(c2));
										}
									}
							}
					}
		}
	}*/
}
