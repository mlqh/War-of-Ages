package Core;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Panels.LoginPanel;
import Panels.MenuPanel;
import Panels.RulesPanel;

import java.awt.CardLayout;
import java.awt.Point;
import java.awt.Toolkit;

public class GameFrame extends JFrame implements GameConstants {

    JPanel cardsPanel, loginPanel, menuPanel, rulesPanel, playPanel, overPanel;

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
                new ImageIcon(this.getClass().getResource("../Assets/cursor" + PNG_EXT)).getImage(), new Point(0, 0),
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
