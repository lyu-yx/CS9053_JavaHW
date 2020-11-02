package assignment7.part1;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;


public class WordFinder extends JFrame {

	JFileChooser jFileChooser;
	private JPanel topPanel; // the top line of objects is going to go here
	private JTextArea wordsBox; // results of the search go in here.
	private JLabel findLabel;
	private JTextField findField;
	private JButton clearButton;

	private final static int AREA_ROWS = 10;
	private final static int AREA_COLUMNS = 30;


	WordList wordList;
	JList list;



	public WordFinder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set the size correctly
		this.setSize(500, 300);
		jFileChooser = new JFileChooser("words100");
		wordList = new WordList();

		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setSize(400, 180);

		// Construct menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());

		// there should be objects in the top panel
		createFindField();

		createButton();
		//panel at the top
		add(createTopPanel(), BorderLayout.NORTH);
		// There should probably be something passed into the JScrollPane
		creatTextArea();
		JScrollPane scrollPane = new JScrollPane(wordsBox);
		add(scrollPane);

		DefaultListModel model = new DefaultListModel();
		list = new JList(model);

		// and of course you will want them to be properly aligned in the frame

	}


	//#############################   Menu Part   ################################################
	public JMenu createFileMenu()
	{
		/* add a "File" menu with:
 		 "Open" item which allows you to choose a new file
		 "Exit" item which ends the process with System.exit(0);
		 * Key shortcuts are optional
		 */
		JMenu menu = new JMenu("File");
		menu.add(createFileOpenItem());
		menu.add(createFileExitItem());
		return menu;
	}

	/**
	 Creates the File->Exit menu item and sets its action listener.
	 @return the menu item
	 */
	public JMenuItem createFileExitItem()
	{
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}

	/**
	 Creates the File->Open menu item and sets its action listener.
	 @return the menu item
	 */
	public JMenuItem createFileOpenItem()
	{
		JMenuItem item = new JMenuItem("Open");
		/* OpenActionListener that will open the file chooser */
		class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}
		ActionListener listener = new OpenActionListener();
		item.addActionListener(listener);
		return item;
	}


//############################   topPenal Part   ########################################
	public void createButton()
	{
		clearButton = new JButton("Clear");

		class AddInterestListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				findField.setText("");
				findField.setCaretPosition(0);
			}
		}

		ActionListener listener = new AddInterestListener();
		clearButton.addActionListener(listener);
	}

	public void createFindField()
	{
		findLabel = new JLabel("Find: ");
		final int FIELD_WIDTH = 10;
		findField = new JTextField(FIELD_WIDTH);
		findField.setText("");
		findField.addCaretListener(new TypingListener());
	}

	public JPanel createTopPanel() {
		topPanel = new JPanel();
		topPanel.add(findLabel);
		topPanel.add(findField);
		topPanel.add(clearButton);
		//topPanel.add(bottomPanel, BorderLayout.SOUTH);
		add(topPanel);
		return topPanel;
	}

//############################   Text Area Part   ########################################

	public void creatTextArea() {
		wordsBox = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		wordsBox.setEditable(false);

	}

	class TypingListener implements CaretListener {
		@Override
		public void caretUpdate(CaretEvent e) {
			try {
				find();
			} catch (Exception err) {
				System.out.println("Open a file.");
			}
		}
	}

	private void find() {
		List searchResult = wordList.find(findField.getText()); // figure out from WordList how to get this
		// you're going to want to get the words in the
		// searchResult list and put them in the textbox.
		wordsBox.setText("");
		for (Iterator i = searchResult.iterator(); i.hasNext(); ) {
			wordsBox.append(i.next() + "\n");
		}
		wordsBox.setCaretPosition(0);
	}

	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println("You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());
					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);
					List searchResult = null; // figure out from WordList how to get this
					// because you will load in a wordlist and there
					// might be data in the search box
				} catch (IOException error){
					error.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args) {
		WordFinder wordFinder = new WordFinder();
		wordFinder.setVisible(true);
	}
}
