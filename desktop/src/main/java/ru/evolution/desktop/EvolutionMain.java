package ru.evolution.desktop;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import ru.evolution.client.model.Creature;
import ru.evolution.core.Ability;
import ru.evolution.core.Card;
import ru.evolution.core.CreatureTrait;
import ru.evolution.core.PlayerCard;

public class EvolutionMain {
public static void main(String[] args) {
        EventQueue.invokeLater( new Runnable() {
            public void run() {
                try {
                    /*GameEngine engine = new GameEngine();
                    engine.createGame();*/
                    
                    EvolutionMain.createFrame();
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
        
    }
    
    public static void createFrame() {
    	//Player p = new Player("Player 1");
    	//Ability ability = Ability.CARNIVOROUS;
        //Card card = new Card(ability);
    	Ability ability = Ability.CARNIVOROUS;
        Ability ability2 = Ability.FAT_ISSUE;
    	List<PlayerCard> cards = new ArrayList<PlayerCard>();
        PlayerCard card = new PlayerCard(new Card("UNKNOWN", ability,ability2));
        cards.add(card);
        card = new PlayerCard(new Card("UNKNOWN", ability,ability2));
        cards.add(card);
        card = new PlayerCard(new Card("UNKNOWN", ability,ability2));
        cards.add(card);
        card = new PlayerCard(new Card("UNKNOWN", ability,ability2));
        cards.add(card);
        card = new PlayerCard(new Card("UNKNOWN", ability,ability2));
        cards.add(card);
        ru.evolution.core.Creature creature = new ru.evolution.core.Creature(card);
        CreatureTrait ca = new CreatureTrait(card, creature);
        //creature.addAbility(ca);
        Creature cm = new Creature();
        cm.abilities.add(ca);
        List<Creature> models = new ArrayList<Creature>();
        models.add(cm);
    	EvolutionFrame frame = new EvolutionFrame(new ru.evolution.client.model.Evolution(cards, models));
        frame.setVisible(true);
                                                
        /*session.getChannels().put( "output", new JTextAreaChannel( frame.getOutputTextArea() ) );
        session.getChannels().put( "events",  new JTextAreaChannel( frame.getLocalEventsTextArea() ) );
        session.getChannels().put( "exits", new JTableChannel( frame.getExitsTable() ) );
        session.getChannels().put( "things", new JTableChannel( frame.getThingsTable()) );
        session.getChannels().put( "inventory", new JTableChannel( frame.getInventoryTable()) );
        session.getChannels().put( "characters", new JComboBoxChannel( frame.getCharacterSelectCombo() ) );
        
        frame.setGameEngine( engine );
        
        engine.ksession.insert( session );
        engine.ksession.fireAllRules();*/
    } 
}
