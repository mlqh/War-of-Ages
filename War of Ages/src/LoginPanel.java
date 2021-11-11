import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements GameConstants {

    static JTextField firstLoginField, secondLoginField;

    public LoginPanel() {
        setLayout(null);

        ImageIcon background = new ImageIcon(this.getClass().getResource(BACKGROUND_PATH + "Login.jpg"));
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(background);

        JLabel firstLoginLabel = new JLabel("Enter player 1 username: ");
        JLabel secondLoginLabel = new JLabel("Enter player 2 username: ");
        firstLoginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        secondLoginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        firstLoginLabel.setForeground(Color.WHITE);
        secondLoginLabel.setForeground(Color.WHITE);

        firstLoginField = new JTextField(20);
        secondLoginField = new JTextField(20);
        JButton OKButton = new JButton("OK");
        OKButton.setActionCommand("OK");

        add(OKButton);
        add(firstLoginLabel);
        add(secondLoginLabel);
        add(firstLoginField);
        add(secondLoginField);
        add(backgroundLabel);

        backgroundLabel.setBounds(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        firstLoginLabel.setBounds(350, 295, 350, 50);
        firstLoginField.setBounds(670, 303, 250, 40);

        secondLoginLabel.setBounds(350, 365, 350, 50);
        secondLoginField.setBounds(670, 373, 250, 40);
        OKButton.setBounds(505, 550, 200, 60);

        OKButton.addActionListener(new ButtonListener(this));

    }

}
