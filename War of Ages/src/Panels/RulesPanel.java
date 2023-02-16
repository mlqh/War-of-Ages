package Panels;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.ButtonListener;
import Core.GameConstants;

public class RulesPanel extends JPanel implements GameConstants {

    private JLabel firstLabel, secondLabel;
    private JButton nextButton, OKButton;
    private ImageIcon firstBackground, secondBackground;

    public RulesPanel() {
        setLayout(null);
        firstBackground = new ImageIcon(this.getClass().getResource(BACKGROUND_PATH + "RulesFirst.jpg"));
        this.firstLabel = new JLabel(firstBackground);

        this.nextButton = new JButton("Next");
        nextButton.setActionCommand("next");
        nextButton.addActionListener(new ButtonListener(this));

        add(nextButton);
        add(firstLabel);
        firstLabel.setBounds(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        nextButton.setBounds(505, 580, 180, 55);
    }

    // second page of rules
    public void nextSlide() {
        this.remove(firstLabel);
        this.remove(nextButton);

        secondBackground = new ImageIcon(this.getClass().getResource(BACKGROUND_PATH + "RulesSecond.jpg"));
        secondLabel = new JLabel(secondBackground);

        OKButton = new JButton("OK");
        OKButton.setActionCommand("OK - rules");
        OKButton.addActionListener(new ButtonListener(this));

        this.add(OKButton);
        this.add(secondLabel);
        OKButton.setBounds(909, 35, 180, 55);
        secondLabel.setBounds(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
    }

    public void reset() {
        this.remove(secondLabel);
        this.remove(OKButton);

        this.add(nextButton);
        this.add(firstLabel);
        firstLabel.setBounds(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        nextButton.setBounds(505, 580, 180, 55);
    }

}
