package finalproject.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        ActionListener threeOfaKindButtonListener = new ThreeOfaKindListener();
        threeOfaKindButton.addActionListener(threeOfaKindButtonListener);

        fourOfaKindButton = new JButton("4 of a kind");
        ActionListener fourOfaKindButtonListener = new FourOfaKindListener();
        fourOfaKindButton.addActionListener(fourOfaKindButtonListener);

        fullHouseButton = new JButton("Full House");
        ActionListener smallStraightButtonListener = new FullHouseListener();
        fullHouseButton.addActionListener(smallStraightButtonListener);

        smallStraightButton = new JButton("Small Straight");
        ActionListener fullHouseButtonListener = new SmallStraightListener();
        smallStraightButton.addActionListener(fullHouseButtonListener);

        largeStraightButton = new JButton("Large Straight");
        ActionListener largeStraightButtonListener = new LargeStraightListener();
        largeStraightButton.addActionListener(largeStraightButtonListener);

        yahtzeeButton = new JButton("Yahtzee");
        ActionListener yahtzeeButtonListener = new YahtzeeListener();
        yahtzeeButton.addActionListener(yahtzeeButtonListener);

        chanceButton = new JButton("Chance");
        ActionListener chanceButtonListener = new ChanceListener();
        chanceButton.addActionListener(chanceButtonListener);
                
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


    public static void renewLowerScore(List<Integer> imageSequence) {
        threeOfaKindTextArea.setText(" " + ComputeAlgorithms.threeOfaKind);
        fourOfaKindTextArea.setText(" " + ComputeAlgorithms.fourOfaKind);
        fullHouseTextArea.setText(" " + ComputeAlgorithms.fullHouse);
        smallStraightTextArea.setText(" " + ComputeAlgorithms.smallStraight);
        largeStraightTextArea.setText(" " + ComputeAlgorithms.largeStraight);
        yahtzeeTextArea.setText(" " + ComputeAlgorithms.yahtzee);
        chanceTextArea.setText(" " + ComputeAlgorithms.chance);
        yahtzeeBonusTextArea.setText(" " + ComputeAlgorithms.computeYahtzeeBonus());
        totalofLowerSectionTextArea.setText(" " + ComputeAlgorithms.computeLowerSum());
        grandTotalTextArea.setText(" " + ComputeAlgorithms.computeGrandTotal());
    }


    //***************************LowerPanel Listeners**********************************
    private void refresh() {
        ComputeAlgorithms.resetAll();
        ImagePanel.currRound = 0;
        ImagePanel.rollLabel.setText("Start Random Roll");
        ImagePanel.currTurn++;
        if (ImagePanel.currTurn == 13) {
            JOptionPane.showMessageDialog(null, "Game Over");
        }
        ImagePanel.turnLabel.setText("Turn: " + ImagePanel.currTurn);
    }

//            threeOfaKindTextArea, fourOfaKindTextArea, fullHouseTextArea,
//            smallStraightTextArea, largeStraightTextArea, yahtzeeTextArea,
//            chanceTextArea, yahtzeeBonusTextArea, totalofLowerSectionTextArea, grandTotalTextArea;
    class ThreeOfaKindListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[6] = true;
            threeOfaKindTextArea.setBackground(Color.LIGHT_GRAY);
            threeOfaKindButton.setEnabled(false);
            refresh();
        }
    }

    class FourOfaKindListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[7] = true;
            fourOfaKindTextArea.setBackground(Color.LIGHT_GRAY);
            fourOfaKindButton.setEnabled(false);
            refresh();
        }
    }

    class FullHouseListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[8] = true;
            fullHouseTextArea.setBackground(Color.LIGHT_GRAY);
            fullHouseButton.setEnabled(false);
            refresh();
        }
    }

    class SmallStraightListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[9] = true;
            smallStraightTextArea.setBackground(Color.LIGHT_GRAY);
            smallStraightButton.setEnabled(false);
            refresh();
        }
    }

    class LargeStraightListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[10] = true;
            largeStraightTextArea.setBackground(Color.LIGHT_GRAY);
            largeStraightButton.setEnabled(false);
            refresh();
        }
    }

    class YahtzeeListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[11] = true;
            yahtzeeTextArea.setBackground(Color.LIGHT_GRAY);
            yahtzeeButton.setEnabled(false);
            refresh();
        }
    }

    class ChanceListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[12] = true;
            chanceTextArea.setBackground(Color.LIGHT_GRAY);
            chanceButton.setEnabled(false);
            refresh();
        }
    }




    public static void setLowerButtonAndArea() {
        if (ComputeAlgorithms.isOccupied[6]) {
            threeOfaKindTextArea.setBackground(Color.LIGHT_GRAY);
            threeOfaKindButton.setEnabled(false);
        }
        if (ComputeAlgorithms.isOccupied[7]) {
            fourOfaKindTextArea.setBackground(Color.LIGHT_GRAY);
            fourOfaKindButton.setEnabled(false);
        }
        if (ComputeAlgorithms.isOccupied[8]) {
            fullHouseTextArea.setBackground(Color.LIGHT_GRAY);
            fullHouseButton.setEnabled(false);
        }
        if (ComputeAlgorithms.isOccupied[9]) {
            smallStraightTextArea.setBackground(Color.LIGHT_GRAY);
            smallStraightButton.setEnabled(false);
        }
        if (ComputeAlgorithms.isOccupied[10]) {
            largeStraightTextArea.setBackground(Color.LIGHT_GRAY);
            largeStraightButton.setEnabled(false);
        }
        if (ComputeAlgorithms.isOccupied[11]) {
            yahtzeeTextArea.setBackground(Color.LIGHT_GRAY);
            yahtzeeButton.setEnabled(false);
        }
        if (ComputeAlgorithms.isOccupied[12]) {
            chanceTextArea.setBackground(Color.LIGHT_GRAY);
            chanceButton.setEnabled(false);
        }
    }
}
