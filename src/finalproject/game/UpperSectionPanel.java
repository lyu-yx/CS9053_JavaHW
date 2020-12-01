package finalproject.game;

import javax.swing.*;
import java.awt.*;

public class UpperSectionPanel extends JPanel {

    private JButton acesButton, twosButton, threesButton, foursButton, fivesButton, sixsButton;
    private JTextArea acesTextArea, twosTextArea, threesTextArea,
            foursTextArea, fivesTextArea, sixsTextArea,
            subTotalTextArea, bonusTextArea, grandTotalTextArea;
    private JLabel subTotalLabel, bonusLabel, grandTotalLabel;

    public UpperSectionPanel() {
        acesButton = new JButton("Aces");
        twosButton = new JButton("Twos");
        threesButton = new JButton("Threes");
        foursButton = new JButton("Fours");
        fivesButton = new JButton("Fives");
        sixsButton = new JButton("sixs");

        subTotalLabel = new JLabel("Score Subtotal");
        bonusLabel = new JLabel("Bonus");
        grandTotalLabel = new JLabel("Grand Total");


        acesTextArea = new JTextArea();
        acesTextArea.setEditable(false);
        twosTextArea = new JTextArea();
        twosTextArea.setEditable(false);
        threesTextArea = new JTextArea();
        threesTextArea.setEditable(false);
        foursTextArea = new JTextArea();
        foursTextArea.setEditable(false);
        fivesTextArea = new JTextArea();
        fivesTextArea.setEditable(false);
        sixsTextArea = new JTextArea();
        sixsTextArea.setEditable(false);
        subTotalTextArea = new JTextArea();
        subTotalTextArea.setEditable(false);
        bonusTextArea = new JTextArea();
        bonusTextArea.setEditable(false);
        grandTotalTextArea = new JTextArea();
        grandTotalTextArea.setEditable(false);
    }

    JPanel createUpperSectionPanel() {
        JPanel upperPanel = new JPanel(new GridLayout(9,2,10,10));
        upperPanel.setBorder(BorderFactory.createTitledBorder("Upper Section"));

        JPanel acesButtonPanel = new JPanel(new FlowLayout(10));
        acesButtonPanel.add(acesButton);
        upperPanel.add(acesButtonPanel);
        upperPanel.add(acesTextArea);

        JPanel twosButtonPanel = new JPanel(new FlowLayout(10));
        twosButtonPanel.add(twosButton);
        upperPanel.add(twosButtonPanel);
        upperPanel.add(twosTextArea);

        JPanel threesButtonPanel = new JPanel(new FlowLayout(10));
        threesButtonPanel.add(threesButton);
        upperPanel.add(threesButtonPanel);
        upperPanel.add(threesTextArea);

        JPanel foursButtonPanel = new JPanel(new FlowLayout(10));
        foursButtonPanel.add(foursButton);
        upperPanel.add(foursButtonPanel);
        upperPanel.add(foursTextArea);

        JPanel fivesButtonPanel = new JPanel(new FlowLayout(10));
        fivesButtonPanel.add(fivesButton);
        upperPanel.add(fivesButtonPanel);
        upperPanel.add(fivesTextArea);

        JPanel sixsButtonPanel = new JPanel(new FlowLayout(10));
        sixsButtonPanel.add(sixsButton);
        upperPanel.add(sixsButtonPanel);
        upperPanel.add(sixsTextArea);

        upperPanel.add(subTotalLabel);
        upperPanel.add(subTotalTextArea);

        upperPanel.add(bonusLabel);
        upperPanel.add(bonusTextArea);

        upperPanel.add(grandTotalLabel);
        upperPanel.add(grandTotalTextArea);


        return upperPanel;
    }
}
