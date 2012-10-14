package ru.evolution.core.test;

import java.util.Arrays;

import junit.framework.TestCase;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.agent.KnowledgeAgentConfiguration;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

import ru.evolution.core.Ability;
import ru.evolution.core.Card;
import ru.evolution.core.Creature;
import ru.evolution.core.CreatureTrait;


public class Simple extends TestCase {
	KnowledgeBase kbase;
	
	public void setUp() {
		System.out.println("set up...");
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Rules.drl", getClass()), ResourceType.DRL);
        if ( kbuilder.hasErrors() ) {
            System.out.println( kbuilder.getErrors().toString() );
            System.exit(1);
        }
        //KnowledgeAgentConfiguration aconf = KnowledgeAgentFactory.newKnowledgeAgentConfiguration();
        //aconf.setProperty("drools.agent.newInstance", "false"); //incremental change set processing enabled

        kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
	}
	
	public void testCarnivorous() {
		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
		Creature carnivorous = new Creature(null);
		carnivorous.setFood(0);
		carnivorous.setRequiredFood(1);
        
        Creature creature = new Creature(null);
        creature.setFood(0);
        creature.setRequiredFood(1);
        
        // не хищник
        ksession.execute(Arrays.asList(new Object[] { carnivorous, creature }));
        assertFalse(carnivorous.isCarnivorous());
        assertFalse(creature.isCarnivorous());
        
        /*Ability ability = Ability.CARNIVOROUS;
        Card card = new Card(ability);
        new CreatureAbility(card, ability, carnivorous);
        // хищник, все голодные
        ksession.execute(Arrays.asList(new Object[] { carnivorous, creature }));
        assertTrue(carnivorous.isCarnivorous());
        assertFalse(creature.isCarnivorous());
        
        carnivorous.setFood(1);
        // хищник сыт
        ksession.execute(Arrays.asList(new Object[] { carnivorous, creature }));
        assertFalse(carnivorous.isCarnivorous());
        assertFalse(creature.isCarnivorous());*/
	}
	
/*	public void testPiracy() {
		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
		Creature pirate = new Creature();
		pirate.setFood(0);
		pirate.setRequiredFood(1);
        
        Creature creature = new Creature();
        creature.setFood(0);
        creature.setRequiredFood(1);
        
        // не пират
        ksession.execute(Arrays.asList(new Object[] { pirate, creature }));
        assertFalse(pirate.isCanPirate());
        assertFalse(creature.isCanPirate());
        
        Ability ability = Ability.PIRACY;
        Card card = new Card(ability);
        new CreatureAbility(card, ability, pirate);
        // пират, все голодные
        ksession.execute(Arrays.asList(new Object[] { pirate, creature }));
        assertTrue(pirate.isCanPirate());
        assertFalse(creature.isCanPirate());
        
        pirate.setFood(1);
        // пират сыт
        ksession.execute(Arrays.asList(new Object[] { pirate, creature }));
        assertFalse(pirate.isCanPirate());
        assertFalse(creature.isCanPirate());
        
        pirate.setFood(0);
        creature.setFood(1);
        // жертва сыта
        ksession.execute(Arrays.asList(new Object[] { pirate, creature }));
        assertFalse(pirate.isCanPirate());
        assertFalse(creature.isCanPirate());
	}*/
}
