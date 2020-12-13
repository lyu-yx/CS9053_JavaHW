package finalproject.game;

import javax.swing.*;

public class PlayerNamePanel extends JPanel{
    public static JTextField playerNameText;
    public static String playerName = "defaultName";
    private JLabel playerNameLabel;
    private JPanel playerPanel;

    public PlayerNamePanel() {
        playerPanel = new JPanel();
        playerNameLabel = new JLabel("Player Name: ");
        playerNameText = new JTextField(25);
        playerName = playerNameText.getText();

    }

    public JPanel createPlayerNamePanel() {
        playerPanel.add(playerNameLabel);
        playerPanel.add(playerNameText);
        return playerPanel;
    }

    public static String getPlayerName() {
        return playerName = playerNameText.getText();
    }


}
