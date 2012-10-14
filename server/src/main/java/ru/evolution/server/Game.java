package ru.evolution.server;

import java.util.ArrayList;
import java.util.List;

import ru.evolution.core.Ability;
import ru.evolution.core.Card;

public class Game {
	List<Card> m_cards = new ArrayList<Card>();
	
	public List<Card> initCards() {
		List<Card> cards = new ArrayList<Card>();
		for(int i = 0; i < 4; i++) {
			cards.add(new Card("GRAZING_AND_FAT_ISSUE", Ability.GRAZING, Ability.FAT_ISSUE));
			cards.add(new Card("PARASITE_AND_FAT_ISSUE", Ability.PARASITE, Ability.FAT_ISSUE));
			cards.add(new Card("PARASITE_AND_CARNIVOROUS", Ability.PARASITE, Ability.CARNIVOROUS));
			cards.add(new Card("COOPERATION_AND_CARNIVOROUS", Ability.COOPERATION, Ability.CARNIVOROUS));
			cards.add(new Card("COOPERATION_AND_FAT_ISSUE", Ability.COOPERATION, Ability.FAT_ISSUE));
			cards.add(new Card("COMMUNICATION_AND_CARNIVOROUS", Ability.COMMUNICATION, Ability.CARNIVOROUS));
			cards.add(new Card("CAMOUFLAGE_AND_FAT_ISSUE", Ability.CAMOUFLAGE, Ability.FAT_ISSUE));
			cards.add(new Card("POISONOUS_AND_CARNIVOROUS", Ability.POISONOUS, Ability.CARNIVOROUS));
			cards.add(new Card("SHARP_VISION_AND_FAT_ISSUE", Ability.SHARP_VISION, Ability.FAT_ISSUE));
			cards.add(new Card("HIGH_BODY_WEIGHT_AND_CARNIVOROUS", Ability.HIGH_BODY_WEIGHT, Ability.CARNIVOROUS));
			cards.add(new Card("HIGH_BODY_WEIGHT_AND_FAT_ISSUE", Ability.HIGH_BODY_WEIGHT, Ability.FAT_ISSUE));
			cards.add(new Card("HIBRENATION_ABILITY_AND_CARNIVOROUS", Ability.HIBRENATION_ABILITY, Ability.CARNIVOROUS));
			cards.add(new Card("MIMICRY", Ability.MIMICRY));
			cards.add(new Card("SYMBIOSYS", Ability.SYMBIOSYS, Ability.SYMBIOSYS_SYMBIONT));
			cards.add(new Card("BURROWING_AND_FAT_ISSUE", Ability.BURROWING, Ability.FAT_ISSUE));
			cards.add(new Card("SCAVANGER", Ability.SCAVANGER));
			cards.add(new Card("PIRACY", Ability.PIRACY));
			cards.add(new Card("TAIL_LOSS", Ability.TAIL_LOSS));
			cards.add(new Card("RUNNING", Ability.RUNNING));
			cards.add(new Card("SWIMMING", Ability.SWIMMING));
			cards.add(new Card("SWIMMING", Ability.SWIMMING));
		}
		return cards;		
	}
}
