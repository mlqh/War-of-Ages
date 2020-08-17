/**
 * ButtonListener.java
 * Listens to JButtons
 * Matthew Hao
 * Jan 20, 2020
 */

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ButtonListener implements ActionListener {
    GameFrame gameFrame;
    JPanel holdingPanel;
    JPanel cardsPanel;
    String source;
    CardLayout layout;
    
    ButtonListener(JPanel target) { 
        this.holdingPanel = target;
    }
    
    public void actionPerformed(ActionEvent event)  { 
        this.source = ((JButton) event.getSource()).getActionCommand();
        gameFrame = (GameFrame) SwingUtilities.getRoot(this.holdingPanel);
        cardsPanel = gameFrame.getCardsPanel();
        layout = (CardLayout) cardsPanel.getLayout();
        
        if(this.source.equals("OK")) {
            layout.show(cardsPanel, "menu");
            
        } else if(this.source.equals("OK - rules")) {
            ((RulesPanel)gameFrame.rulesPanel).reset();
            layout.show(cardsPanel, "menu");
            
        } else if(this.source.equals("rules")) {
            layout.show(cardsPanel, "rules");
            
        } else if(this.source.equals("next")) {
            ((RulesPanel) this.holdingPanel).nextSlide();
            
        } else if(this.source.equals("start")) {
            PlayPanel playPanel = new PlayPanel();
            cardsPanel.add(playPanel, "play");
            layout.show(cardsPanel, "play");
            playPanel.requestFocusInWindow();
            playPanel.runGame(playPanel);
            
        } else if(this.source.equals("quit")) {
            gameFrame.dispose();
        }
    }    
}