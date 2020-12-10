package finalproject.server;

import javax.swing.*;
import java.awt.*;

public class SaveServer extends JFrame {

	private JTextArea wordsBox;
	
	public SaveServer() {
		createMainPanel();
		wordsBox.append("Ready to Accept Connections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setVisible(true);
	}
	
	public void createMainPanel() {
		wordsBox = new JTextArea(35,10);

		JScrollPane listScroller = new JScrollPane(wordsBox);
		this.add(listScroller, BorderLayout.CENTER);
		listScroller.setPreferredSize(new Dimension(250, 80));
	}
	
	public static void main(String[] main) {
		SaveServer saveServer = new SaveServer();

	}
}
