package ru.evolution.server;


public class GameEngine {
	public void createGame() {
		//KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        //kbuilder.add(ResourceFactory.newClassPathResource("Model.drl", getClass()), ResourceType.DRL);
        /*kbuilder.add(ResourceFactory.newClassPathResource("Rules.drl", getClass()), ResourceType.DRL);
        if ( kbuilder.hasErrors() ) {
            System.out.println( kbuilder.getErrors().toString() );
            System.exit( 1 );
        }
        
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
        
        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
        Creature pirate = new Creature();
        Creature sac = new Creature();
        sac.m_food = 0;
        sac.m_requiredFood = 1;
        pirate.setFood(1);
		pirate.setRequiredFood(1);
        Ability ability = Ability.PIRACY;
        Card card = new Card(ability);
        new CreatureAbility(card, ability, pirate);
        System.out.println( pirate.isCanPirate() );*/
        /*List<Command> cmds = new ArrayList<Command>();
        cmds.add( CommandFactory.newInsert( pirate, "p" ));
        cmds.add( CommandFactory.newInsert( sac, "s" ));
        ksession.execute( CommandFactory.newBatchExecution( cmds ) );*/
        //assertEquals( new Person( "Mr John Smith" ), results.getValue( "mrSmith" ) );

        //ksession.execute( Arrays.asList( new Object[] { pirate, sac } )  );
        //ksession.execute( pirate );
        //System.out.println( pirate.isCanPirate() );
	}
}
