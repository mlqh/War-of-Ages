/**
 * MenuPanel.java
 * JPanel for menu
 * Matthew Hao
 * Jan 20, 2020
 */

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements GameConstants {
    
    public MenuPanel() {
        setLayout(null);
        ImageIcon background = new ImageIcon(BACKGROUND_PATH + "Menu.jpg");
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(background);
        
        JButton rulesButton = new JButton("Rules");
        JButton playButton = new JButton("Start Game");
        rulesButton.setActionCommand("rules");
        playButton.setActionCommand("start");
        
        add(rulesButton);
        add(playButton);
        add(backgroundLabel);
        
        backgroundLabel.setBounds(0, 0, 1200, 675);
        rulesButton.setBounds(305, 500, 270, 60);
        playButton.setBounds(655, 500, 270, 60);
        
        rulesButton.addActionListener(new ButtonListener(this));
        playButton.addActionListener(new ButtonListener(this));
    }
    
    
    
    
}
