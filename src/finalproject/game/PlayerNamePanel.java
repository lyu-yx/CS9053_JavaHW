package finalproject.game;

import javax.swing.*;

public class PlayerNamePanel extends JPanel{
    private JLabel playerNameLabel;
    private JTextField playerNameText;
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


}
