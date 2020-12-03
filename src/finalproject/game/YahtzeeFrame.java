package finalproject.game;

import javax.swing.*;
import java.awt.*;

public class YahtzeeFrame extends JFrame {

	
	public YahtzeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JPanel scorePanel = new JPanel(new GridLayout(2,1));
		JPanel lowerPanel = new JPanel(new FlowLayout());
		JPanel dicePanel = ImagePanel.createDicePanel();

		UpperSectionPanel upperSectionPanel = new UpperSectionPanel();
		LowerSectionPanel lowerSectionPanel = new LowerSectionPanel();
		scorePanel.add(upperSectionPanel.createUpperSectionPanel());
		scorePanel.add(lowerSectionPanel.createLowerSectionPanel());

		lowerPanel.add(scorePanel);
		lowerPanel.add(dicePanel);
		this.add(lowerPanel);

//		this.add(upperSectionPanel.createUpperSectionPanel());
//		this.add(lowerSectionPanel.createLowerSectionPanel());
	}





	
	public static void main(String args[]) {
		YahtzeeFrame yahtzee = new YahtzeeFrame();
		yahtzee.setVisible(true);
	}
}
