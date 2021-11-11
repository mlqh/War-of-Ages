import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Point;
import java.awt.Toolkit;

class GameFrame extends JFrame implements GameConstants {

    static JPanel cardsPanel, loginPanel, menuPanel, rulesPanel, playPanel, overPanel;

    public GameFrame() {
        // set up frame
        setTitle("War of Ages");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setFocusable(false);

        // set a custom cursor
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(this.getClass().getResource("Images/cursor" + PNG_EXT)).getImage(), new Point(0, 0),
                "custom cursor"));

        cardsPanel = new JPanel(new CardLayout());
        loginPanel = new LoginPanel();
        menuPanel = new MenuPanel();
        rulesPanel = new RulesPanel();

        cardsPanel.add(loginPanel, "login");
        cardsPanel.add(menuPanel, "menu");
        cardsPanel.add(rulesPanel, "rules");

        add(cardsPanel);
        setVisible(true);
    }

    public JPanel getCardsPanel() {
        return this.cardsPanel;
    }

}
