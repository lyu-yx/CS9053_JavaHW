package finalproject.game;

import javax.swing.*;

public class YahtzeeFrame extends JFrame {

	
	public YahtzeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		UpperSectionPanel upperSectionPanel = new UpperSectionPanel();
		this.add(upperSectionPanel.createUpperSectionPanel());
	}





	
	public static void main(String args[]) {
		YahtzeeFrame yahtzee = new YahtzeeFrame();
		yahtzee.setVisible(true);
	}
}
