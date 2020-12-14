package finalproject.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ImagePanel extends JPanel {
	static ActionListener listener;
    static int currRound = 0, currTurn = 0;
	private Image img;
	private JLabel l;
	static Image[] diceImages = new Image[6];
	public static List<ImagePanel> imagePanelList;
	public static List<Integer> imageSequence;
	public static List<JCheckBox> checkBoxesList;
	private int currDiceNum;
	static JLabel turnLabel, rollLabel;

	public ImagePanel() {

		for (int i=0;i<6;i++) {
			diceImages[i] = new ImageIcon("pic/" + "die"+(i+1) +".png").getImage();
		}
		imageSequence = new ArrayList<Integer>();
		//setLayout(new FlowLayout(FlowLayout.LEFT));

	}

	public static void repaintAllDice(List<ImagePanel> imagePanelList) {
		for (int i = 0; i < 5; i++) {
			imagePanelList.get(i).setImage(diceImages[imageSequence.get(i)]);
			imagePanelList.get(i).scaleImage(0.5);
		}
	}

	public static void repaintAllCheckBox (boolean[] checkBox, List<JCheckBox> checkBoxesList) {
		for (int i = 0; i < 5; i++) {
			checkBoxesList.get(i).setSelected(checkBox[i]);
		}
	}

	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
		for (int i=0;i<6;i++) {
			diceImages[i] = new ImageIcon("pic/" + "die"+(i+1) +".png").getImage();
		}

	}
	
	public ImagePanel(Image img) {
		this();
		this.img = img;
		l = new JLabel(new ImageIcon(this.img));
		add(l);
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        System.out.println("initialization: setting size to " + size.toString());
        setPreferredSize(size);
	}
	
	public void setImage(Image img) {
		this.img = img;
    	System.out.println("repainting");
		repaint();
	}
	
	public void setImage(String img) {
		this.img = new ImageIcon("pic/" + img +".png").getImage();
		repaint();
	}
	
	public void setSequence(List<Integer> al) {
		imageSequence = al;
		repaint();
	}
	
	public void scaleImage(double factor) {
		ImageIcon imageIcon = new ImageIcon(img);
		int height = imageIcon.getIconHeight();
		int width = imageIcon.getIconWidth();
		int newHeight = (int) (height*factor);
		int newWidth = (int) (width*factor);
		System.out.println("scaleImage: new size is  " + newWidth + ", "+ newHeight);
		Image resultingImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
		imageIcon = new ImageIcon(resultingImage);
		l.setIcon(imageIcon);
        Dimension size = new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight());

        System.out.println("scaleImage: setting size to " + size.toString());
		this.img = resultingImage;
        setPreferredSize(size);
		repaint();
	}
	
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	l.repaint();
    }

    public int getCurrDiceNum() {
		return currDiceNum;
	}
	public void setCurrDiceNum() {
		currDiceNum = (int)(Math.random() * 6);
	}
	public void setSpecificDiceNum(int i) {
		currDiceNum = i;
	}

	public static JPanel createDicePanel() {
		JPanel dicePanel = new JPanel(new GridLayout(6,1,20,20));
		JPanel dicePart1Panel, dicePart2Panel, dicePart3Panel, dicePart4Panel, dicePart5Panel, diceControlPanel;

		ImagePanel dice1, dice2, dice3, dice4, dice5;
		JButton rollButton;
		JCheckBox dice1CheckBox, dice2CheckBox, dice3CheckBox, dice4CheckBox, dice5CheckBox;
		imagePanelList = new ArrayList<>();
        checkBoxesList = new ArrayList<>();

		dice1 = new ImagePanel("pic/die1.png");
		dice2 = new ImagePanel("pic/die1.png");
		dice3 = new ImagePanel("pic/die1.png");
		dice4 = new ImagePanel("pic/die1.png");
		dice5 = new ImagePanel("pic/die1.png");

		imagePanelList.add(dice1);
		imagePanelList.add(dice2);
		imagePanelList.add(dice3);
		imagePanelList.add(dice4);
		imagePanelList.add(dice5);

//***********************create 5 ImagePanel******************************************
		dice1CheckBox = new JCheckBox("keep");
		dice1CheckBox.addActionListener(listener);
		dicePart1Panel = new JPanel();
		dicePart1Panel.setLayout(new BoxLayout(dicePart1Panel, BoxLayout.Y_AXIS));
		dice1CheckBox.setAlignmentX((float)0.4);
		//dice1.setImage(dice1.diceImages[2]);
		dice1.scaleImage(0.5);
		dicePart1Panel.add(dice1);
		dicePart1Panel.add(dice1CheckBox);

		dice2CheckBox = new JCheckBox("keep");
		dice2CheckBox.addActionListener(listener);
		dicePart2Panel = new JPanel();
		dicePart2Panel.setLayout(new BoxLayout(dicePart2Panel, BoxLayout.Y_AXIS));
		dice2CheckBox.setAlignmentX((float)0.4);
		dice2.scaleImage(0.5);
		dicePart2Panel.add(dice2);
		dicePart2Panel.add(dice2CheckBox);


		dice3CheckBox = new JCheckBox("keep");
		dice3CheckBox.addActionListener(listener);
		dicePart3Panel = new JPanel();
		dicePart3Panel.setLayout(new BoxLayout(dicePart3Panel, BoxLayout.Y_AXIS));
		dice3CheckBox.setAlignmentX((float)0.4);
		dice3.scaleImage(0.5);
		dicePart3Panel.add(dice3);
		dicePart3Panel.add(dice3CheckBox);


		dice4CheckBox = new JCheckBox("keep");
		dice4CheckBox.addActionListener(listener);
		dicePart4Panel = new JPanel();
		dicePart4Panel.setLayout(new BoxLayout(dicePart4Panel, BoxLayout.Y_AXIS));
		dice4CheckBox.setAlignmentX((float)0.4);
		dice4.scaleImage(0.5);
		dicePart4Panel.add(dice4);
		dicePart4Panel.add(dice4CheckBox);


		dice5CheckBox = new JCheckBox("keep");
		dice5CheckBox.addActionListener(listener);
		dicePart5Panel = new JPanel();
		dicePart5Panel.setLayout(new BoxLayout(dicePart5Panel, BoxLayout.Y_AXIS));
		dice5CheckBox.setAlignmentX((float)0.4);
		dice5.scaleImage(0.5);
		dicePart5Panel.add(dice5);
		dicePart5Panel.add(dice5CheckBox);

        checkBoxesList.add(dice1CheckBox);
        checkBoxesList.add(dice2CheckBox);
        checkBoxesList.add(dice3CheckBox);
        checkBoxesList.add(dice4CheckBox);
        checkBoxesList.add(dice5CheckBox);

//***********************create dice control paenl**********************
		diceControlPanel = new JPanel();
		diceControlPanel.setLayout(new BoxLayout(diceControlPanel, BoxLayout.Y_AXIS));

		turnLabel = new JLabel("Turn:" + currRound);
		rollLabel = new JLabel("Roll: " + currTurn);
		rollButton = new JButton("Roll");

		rollButton.setAlignmentX((float)0.5);
		rollLabel.setAlignmentX((float)0.5);
		turnLabel.setAlignmentX((float)0.5);

		diceControlPanel.add(turnLabel);
		diceControlPanel.add(rollLabel);
		diceControlPanel.add(rollButton);

//***********************checkBoxListener*****************************
	class CheckBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (currRound == 0) {
				JOptionPane.showMessageDialog(null, "First round must be random");
				for (JCheckBox checkBox : checkBoxesList) {
					checkBox.setSelected(false);
				}
			}
		}
	}

		CheckBoxListener boxListener = new CheckBoxListener();
		dice1CheckBox.addActionListener(boxListener);
		dice2CheckBox.addActionListener(boxListener);
		dice3CheckBox.addActionListener(boxListener);
		dice4CheckBox.addActionListener(boxListener);
		dice5CheckBox.addActionListener(boxListener);

//**********************RoLLButtonListener******************
//two listener is designed for rolling dice animation, change randomTime to see this
	class RollButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (currRound < 3) {
				int delay = 150;
				currRound++;
				rollLabel.setText("Roll: " + currRound);
				rollLabel.repaint();
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						imageSequence.clear();
						for (int i = 0; i < imagePanelList.size(); i++) {
							if (!checkBoxesList.get(i).isSelected()) {
								imagePanelList.get(i).setCurrDiceNum();

								imageSequence.add(imagePanelList.get(i).currDiceNum);

								imagePanelList.get(i).setImage(imagePanelList.get(i).diceImages[imagePanelList.get(i).getCurrDiceNum()]);
								imagePanelList.get(i).scaleImage(0.5);

							} else {
								imageSequence.add(imagePanelList.get(i).currDiceNum);
							}
						}
						ComputeAlgorithms.computeAllPossibleScore(imageSequence);
						UpperSectionPanel.renewUpperScore(imageSequence);
						LowerSectionPanel.renewLowerScore(imageSequence);
					}
				};

				Timer t = new Timer(delay, taskPerformer);
				t.start();

				class rollStopListener implements ActionListener {
					@Override
					public void actionPerformed(ActionEvent e) {

						t.stop();
						UpperSectionPanel.renewUpperScore(imageSequence);
						LowerSectionPanel.renewLowerScore(imageSequence);
					}
				}
				int randomTime = 150;
				Timer stop = new Timer(randomTime, new rollStopListener());

				stop.start();
			} else {
				JOptionPane.showMessageDialog(null, "Run out of opportunity, please select a score type");
			}
		}
	}

		rollButton.addActionListener(new RollButtonListener());

//**********************add components to ImagePanel******************

		dicePanel.add(dicePart1Panel);
		dicePanel.add(dicePart2Panel);
		dicePanel.add(dicePart3Panel);
		dicePanel.add(dicePart4Panel);
		dicePanel.add(dicePart5Panel);
		dicePanel.add(diceControlPanel);

		return dicePanel;
	}


}
