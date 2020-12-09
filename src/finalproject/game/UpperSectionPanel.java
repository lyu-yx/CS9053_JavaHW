package finalproject.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UpperSectionPanel extends JPanel {

    private static JButton acesButton, twosButton, threesButton, foursButton, fivesButton, sixsButton;
    private static JTextArea acesTextArea, twosTextArea, threesTextArea,
            foursTextArea, fivesTextArea, sixesTextArea,
            upperTotalTextArea, bonusTextArea, grandTotalTextArea;
    private static JLabel subTotalLabel, bonusLabel, grandTotalLabel;

    public UpperSectionPanel() {
        acesButton = new JButton("Aces");
        ActionListener acesButtonListener = new AcesListener();
        acesButton.addActionListener(acesButtonListener);

        twosButton = new JButton("Twos");
        ActionListener twosButtonListener = new TwosListener();
        twosButton.addActionListener(twosButtonListener);

        threesButton = new JButton("Threes");
        ActionListener threesButtonListener = new ThreesListener();
        threesButton.addActionListener(threesButtonListener);


        foursButton = new JButton("Fours");
        ActionListener foursButtonListener = new FoursListener();
        foursButton.addActionListener(foursButtonListener);


        fivesButton = new JButton("Fives");
        ActionListener fivesButtonListener = new FivesListener();
        fivesButton.addActionListener(fivesButtonListener);


        sixsButton = new JButton("sixs");
        ActionListener sixesButtonListener = new SixesListener();
        sixsButton.addActionListener(sixesButtonListener);



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
        sixesTextArea = new JTextArea();
        sixesTextArea.setEditable(false);
        upperTotalTextArea = new JTextArea();
        upperTotalTextArea.setEditable(false);
        bonusTextArea = new JTextArea();
        bonusTextArea.setEditable(false);
        grandTotalTextArea = new JTextArea();
        grandTotalTextArea.setEditable(false);
    }

    JPanel createUpperSectionPanel() {
        JPanel upperPanel = new JPanel(new GridLayout(9,2,10,10));
        upperPanel.setBorder(BorderFactory.createTitledBorder("Total of upper section"));

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
        upperPanel.add(sixesTextArea);

        upperPanel.add(subTotalLabel);
        upperPanel.add(upperTotalTextArea);

        upperPanel.add(bonusLabel);
        upperPanel.add(bonusTextArea);

        upperPanel.add(grandTotalLabel);
        upperPanel.add(grandTotalTextArea);


        return upperPanel;
    }
//    JTextArea acesTextArea, twosTextArea, threesTextArea,
//            foursTextArea, fivesTextArea, sixsTextArea,
//            subTotalTextArea, bonusTextArea, grandTotalTextArea;
    public static void renewUpperScore(List<Integer> imageSequence) {
        acesTextArea.setText(" " + ComputeAlgorithms.acesResult);
        twosTextArea.setText(" " + ComputeAlgorithms.twosResult);
        threesTextArea.setText(" " + ComputeAlgorithms.threesResult);
        foursTextArea.setText(" " + ComputeAlgorithms.foursResult);
        fivesTextArea.setText(" " + ComputeAlgorithms.fivesResult);
        sixesTextArea.setText(" " + ComputeAlgorithms.sixesResult);
        upperTotalTextArea.setText(" " + ComputeAlgorithms.computeUpperScoreSum());
        bonusTextArea.setText("" + ComputeAlgorithms.computeUpperBonus());
        grandTotalTextArea.setText("" + ComputeAlgorithms.computeUpperTotal());
    }

//***************************UpperPanel Listeners**********************************
    private void refresh() {
        ComputeAlgorithms.resetAll();
        ImagePanel.currRound = 0;
        ImagePanel.rollLabel.setText("Roll: " + ImagePanel.currRound);
        ImagePanel.currTurn++;
        ImagePanel.turnLabel.setText("Turn: " + ImagePanel.currTurn);
    }


    class AcesListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[0] = true;
            acesTextArea.setBackground(Color.LIGHT_GRAY);
            acesButton.setEnabled(false);
            refresh();
        }
    }

    class TwosListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[1] = true;
            twosTextArea.setBackground(Color.LIGHT_GRAY);
            twosButton.setEnabled(false);
            refresh();
        }
    }

    class ThreesListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[2] = true;
            threesTextArea.setBackground(Color.LIGHT_GRAY);
            threesButton.setEnabled(false);
            refresh();
        }
    }

    class FoursListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[3] = true;
            foursTextArea.setBackground(Color.LIGHT_GRAY);
            foursButton.setEnabled(false);
            refresh();
        }
    }

    class FivesListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[4] = true;
            fivesTextArea.setBackground(Color.LIGHT_GRAY);
            fivesButton.setEnabled(false);
            refresh();
        }
    }

    class SixesListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ComputeAlgorithms.isOccupied[5] = true;
            sixesTextArea.setBackground(Color.LIGHT_GRAY);
            sixsButton.setEnabled(false);
            refresh();
        }
    }




}
