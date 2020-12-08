package finalproject.game;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LowerSectionPanel extends JPanel {

    private static JButton threeOfaKindButton, fourOfaKindButton, fullHouseButton,
                    smallStraightButton, largeStraightButton, yahtzeeButton, chanceButton;
    private static JTextArea threeOfaKindTextArea, fourOfaKindTextArea, fullHouseTextArea,
                    smallStraightTextArea, largeStraightTextArea, yahtzeeTextArea,
                    chanceTextArea, yahtzeeBonusTextArea, totalofLowerSectionTextArea, grandTotalTextArea;
    private static JLabel yahtzeeBonusLabel, totalofLowerSectionLabel, grandTotalLabel;

    public LowerSectionPanel() {
        threeOfaKindButton = new JButton("3 of a kind");
        fourOfaKindButton = new JButton("4 of a kind");
        fullHouseButton = new JButton("Full House");
        smallStraightButton = new JButton("Small Straight");
        largeStraightButton = new JButton("Large Straight");
        yahtzeeButton = new JButton("Yahtzee");
        chanceButton = new JButton("Chance");
                
        yahtzeeBonusLabel = new JLabel("Yahtzee Bonus");
        totalofLowerSectionLabel = new JLabel("Total of lower section");
        grandTotalLabel = new JLabel("Grand Total");


        threeOfaKindTextArea = new JTextArea();
        threeOfaKindTextArea.setEditable(false);
        fourOfaKindTextArea = new JTextArea();
        fourOfaKindTextArea.setEditable(false);
        fullHouseTextArea = new JTextArea();
        fullHouseTextArea.setEditable(false);
        smallStraightTextArea = new JTextArea();
        smallStraightTextArea.setEditable(false);
        largeStraightTextArea = new JTextArea();
        largeStraightTextArea.setEditable(false);
        yahtzeeTextArea = new JTextArea();
        yahtzeeTextArea.setEditable(false);
        chanceTextArea = new JTextArea();
        chanceTextArea.setEditable(false);
        yahtzeeBonusTextArea = new JTextArea();
        yahtzeeBonusTextArea.setEditable(false);
        totalofLowerSectionTextArea = new JTextArea();
        totalofLowerSectionTextArea.setEditable(false);
        grandTotalTextArea = new JTextArea();
        grandTotalTextArea.setEditable(false);
    }

    JPanel createLowerSectionPanel() {
        JPanel lowerPanel = new JPanel(new GridLayout(10,2,10,10));
        lowerPanel.setBorder(BorderFactory.createTitledBorder("Lower Section"));

        JPanel threeOfaKindButtonPanel = new JPanel(new FlowLayout(10));
        threeOfaKindButtonPanel.add(threeOfaKindButton);
        lowerPanel.add(threeOfaKindButtonPanel);
        lowerPanel.add(threeOfaKindTextArea);

        JPanel fourOfaKindButtonPanel = new JPanel(new FlowLayout(10));
        fourOfaKindButtonPanel.add(fourOfaKindButton);
        lowerPanel.add(fourOfaKindButtonPanel);
        lowerPanel.add(fourOfaKindTextArea);

        JPanel fullHouseButtonPanel = new JPanel(new FlowLayout(10));
        fullHouseButtonPanel.add(fullHouseButton);
        lowerPanel.add(fullHouseButtonPanel);
        lowerPanel.add(fullHouseTextArea);

        JPanel smallStraightButtonPanel = new JPanel(new FlowLayout(10));
        smallStraightButtonPanel.add(smallStraightButton);
        lowerPanel.add(smallStraightButtonPanel);
        lowerPanel.add(smallStraightTextArea);

        JPanel largeStraightButtonPanel = new JPanel(new FlowLayout(10));
        largeStraightButtonPanel.add(largeStraightButton);
        lowerPanel.add(largeStraightButtonPanel);
        lowerPanel.add(largeStraightTextArea);

        JPanel yahtzeeButtonPanel = new JPanel(new FlowLayout(10));
        yahtzeeButtonPanel.add(yahtzeeButton);
        lowerPanel.add(yahtzeeButtonPanel);
        lowerPanel.add(yahtzeeTextArea);

        JPanel chanceButtonPanel = new JPanel(new FlowLayout(10));
        chanceButtonPanel.add(chanceButton);
        lowerPanel.add(chanceButtonPanel);
        lowerPanel.add(chanceTextArea);
        
        lowerPanel.add(yahtzeeBonusLabel);
        lowerPanel.add(yahtzeeBonusTextArea);

        lowerPanel.add(totalofLowerSectionLabel);
        lowerPanel.add(totalofLowerSectionTextArea);

        lowerPanel.add(grandTotalLabel);
        lowerPanel.add(grandTotalTextArea);


        return lowerPanel;
    }


//            threeOfaKindTextArea, fourOfaKindTextArea, fullHouseTextArea,
//            smallStraightTextArea, largeStraightTextArea, yahtzeeTextArea,
//            chanceTextArea, yahtzeeBonusTextArea, totalofLowerSectionTextArea, grandTotalTextArea;

    public static void renewLowerScore(List<Integer> imageSequence) {
        threeOfaKindTextArea.setText(" " + ComputeAlgorithms.threeOfaKind);
        fourOfaKindTextArea.setText(" " + ComputeAlgorithms.fourOfaKind);
        fullHouseTextArea.setText(" " + ComputeAlgorithms.fullHouse);
        smallStraightTextArea.setText(" " + ComputeAlgorithms.smallStraight);
        largeStraightTextArea.setText(" " + ComputeAlgorithms.largeStraight);
        yahtzeeTextArea.setText(" " + ComputeAlgorithms.yahtzee);
        chanceTextArea.setText(" " + ComputeAlgorithms.chance);
        yahtzeeBonusTextArea.setText(" " + ComputeAlgorithms.yahtzeeBonus);
        totalofLowerSectionTextArea.setText(" " + ComputeAlgorithms.lowerSum);
        grandTotalTextArea.setText(" " + ComputeAlgorithms.grandTotal);

    }


}
