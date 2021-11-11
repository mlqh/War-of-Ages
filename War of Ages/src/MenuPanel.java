import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements GameConstants {

    public MenuPanel() {
        setLayout(null);
        ImageIcon background = new ImageIcon(this.getClass().getResource(BACKGROUND_PATH + "Menu.jpg"));
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(background);

        JButton rulesButton = new JButton("Rules");
        JButton playButton = new JButton("Start Game");
        rulesButton.setActionCommand("rules");
        playButton.setActionCommand("start");

        add(rulesButton);
        add(playButton);
        add(backgroundLabel);

        backgroundLabel.setBounds(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        rulesButton.setBounds(305, 550, 270, 60);
        playButton.setBounds(655, 550, 270, 60);

        rulesButton.addActionListener(new ButtonListener(this));
        playButton.addActionListener(new ButtonListener(this));
    }

}
