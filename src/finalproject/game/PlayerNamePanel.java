package finalproject.game;

import javax.swing.*;

public class PlayerNamePanel extends JPanel{
    private static JTextField playerNameText;
    private JLabel playerNameLabel;
    private JPanel playerPanel;

    public PlayerNamePanel() {
        playerPanel = new JPanel();
        playerNameLabel = new JLabel("Player Name: ");
        playerNameText = new JTextField(25);

    }

    public JPanel createPlayerNamePanel() {
        playerPanel.add(playerNameLabel);
        playerPanel.add(playerNameText);
        return playerPanel;
    }

    public static String getPlayerName() {
        return playerNameText.getText();
    }


}
