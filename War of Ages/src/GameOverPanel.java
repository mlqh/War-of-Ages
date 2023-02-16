import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel implements GameConstants {

    String winner;

    public GameOverPanel(String winner) {
        setLayout(null);
        ImageIcon background = new ImageIcon(this.getClass().getResource(BACKGROUND_PATH + "GameOver.jpg"));
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(background);
        this.winner = winner;

        JLabel winnerLabel = new JLabel("Winner: " + winner + "!");
        winnerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        winnerLabel.setForeground(Color.WHITE);

        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("OK");
        JButton quitButton = new JButton("Quit");
        quitButton.setActionCommand("quit");

        add(menuButton);
        add(quitButton);
        add(winnerLabel);
        add(backgroundLabel);

        backgroundLabel.setBounds(0, 0, 1200, 675);
        winnerLabel.setBounds(500, 295, 350, 50);

        menuButton.setBounds(380, 500, 200, 70);
        quitButton.setBounds(630, 500, 200, 70);

        menuButton.addActionListener(new ButtonListener(this));
        quitButton.addActionListener(new ButtonListener(this));
    }

}
