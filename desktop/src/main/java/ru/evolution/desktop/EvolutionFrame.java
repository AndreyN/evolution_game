package ru.evolution.desktop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import ru.evolution.client.model.Evolution;
import ru.evolution.desktop.cardarea.AbstractCardArea;

/**
 * TODO узнать, как на весь экран раст€нуть
 * TODO строка состо€ни€
 * TODO некоторые проблемы с прорисовкой выбранной карты. —ейчас сделано так, что код дублируетс€ в обеих панел€х.
 * ћожно вынести этот код сюда. ƒл€ этого может потребоватьс€ переписать метод paint. Ќо это потом, пока не
 * совсем пон€тно, насколько сильно будут переписаны обработчики событий мыши в панел€х.
 * @author RaTor
 *
 */
public class EvolutionFrame extends JFrame implements MouseListener, MouseMotionListener {
	private Evolution model;
	private JPanel contentPane;
	private PlayerCardsPanel playerCardsPanel;
	private CreaturesPanel creaturesPanel;
	
	public EvolutionFrame(Evolution model) {
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		setLocationByPlatform(true);
		setSize(800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        playerCardsPanel = new PlayerCardsPanel(model, 0.5, AbstractCardArea.DEFAULT_HEIGHT);

        playerCardsPanel.addMouseListener(this);
        playerCardsPanel.addMouseMotionListener(this);
        model.setPlayerCardsRender(playerCardsPanel);
        playerCardsPanel.setAutoscrolls(true);
        playerCardsPanel.setBounds(0, 0, 100, 10);
        
        creaturesPanel = new CreaturesPanel(model, 0.3, 0.3, 10, AbstractCardArea.DEFAULT_HEIGHT);
        creaturesPanel.addMouseListener(this);
        creaturesPanel.addMouseMotionListener(this);
        model.setCreaturesRender(creaturesPanel);
		
        JSplitPane splitPane = createSplitPane();
        
        contentPane.add(splitPane);
		setContentPane(splitPane);
        
        splitPane.setTopComponent(playerCardsPanel);
        splitPane.setBottomComponent(creaturesPanel);
        
        addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	protected JSplitPane createSplitPane() {
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setResizeWeight(0.4);
        //System.out.println(splitPane.getDividerSize());
        splitPane.setDividerSize(5);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);
        PropertyChangeListener pclistener = new PropertyChangeListener() {
        	public void propertyChange(PropertyChangeEvent evt) {
    			playerCardsPanel.updateHeight();
        	}
        };
        splitPane.addPropertyChangeListener(JSplitPane.LAST_DIVIDER_LOCATION_PROPERTY, pclistener);
        return splitPane;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if(e.getComponent().equals(playerCardsPanel))
			playerCardsPanel.mousePressed(e);
		if(playerCardsPanel.getSelectedCard() != null)
			creaturesPanel.mousePressed(e, playerCardsPanel.getSelectedCard());
	}

	public void mouseReleased(MouseEvent e) {
		//System.out.println(e.getSource().equals(playerCardsPanel));//e.getSource()
		System.out.println(playerCardsPanel.isEventInside(e.getPoint()));
		if(playerCardsPanel.getSelectedCard() != null) {
			playerCardsPanel.mouseReleased(e);
			
			//if(creaturesPanel.sele)
			
			
			creaturesPanel.mouseReleased(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		if(playerCardsPanel.getSelectedCard() == null)
			return;
		//if(playerCardsPanel.isSelectedCardPainted(e.getPoint()))
			playerCardsPanel.mouseDragged(e);
		creaturesPanel.mouseDragged(e);
	}

	public void mouseMoved(MouseEvent e) {}
}