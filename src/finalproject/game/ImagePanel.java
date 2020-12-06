package finalproject.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ImagePanel extends JPanel {
	private static ActionListener listener;
	private Image img;
	private JLabel l;
	private Image[] diceImages = new Image[6];
	private List<Integer> imageSequence;
	private int currDiceNum;



	public ImagePanel() {
		for (int i=0;i<6;i++) {
			diceImages[i] = new ImageIcon("pic/" + "die"+(i+1) +".png").getImage();
		}
		imageSequence = new ArrayList<Integer>();
		//setLayout(new FlowLayout(FlowLayout.LEFT));

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
		Image resultingImage = img.getScaledInstance(newWidth, newHeight, 
												Image.SCALE_DEFAULT);
		imageIcon = new ImageIcon(resultingImage);
		l.setIcon(imageIcon);
        Dimension size = new Dimension(imageIcon.getIconWidth(), 
        								imageIcon.getIconHeight());

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

    public static JPanel createDicePanel() {
		JPanel dicePanel = new JPanel(new GridLayout(6,1,20,20));
		JPanel dicePart1Panel, dicePart2Panel, dicePart3Panel, dicePart4Panel, dicePart5Panel, diceControlPanel;
		JLabel turnLabel, rollLabel;
		ImagePanel dice1, dice2, dice3, dice4, dice5;
		JButton rollButton;
		JCheckBox dice1CheckBox, dice2CheckBox, dice3CheckBox, dice4CheckBox, dice5CheckBox;
		List<ImagePanel> imagePanelList = new ArrayList<>();



		dice1 = new ImagePanel("pic/die1.png");
		dice2 = new ImagePanel("pic/die2.png");
		dice3 = new ImagePanel("pic/die3.png");
		dice4 = new ImagePanel("pic/die4.png");
		dice5 = new ImagePanel("pic/die5.png");



		imagePanelList.add(dice1);
		imagePanelList.add(dice2);
		imagePanelList.add(dice3);
		imagePanelList.add(dice4);
		imagePanelList.add(dice5);

		//dice1.setImage(dice1.diceImages[2]);
		//***********************create 5 ImagePanel******************************************
		dice1CheckBox = new JCheckBox("keep");
		dice1CheckBox.addActionListener(listener);
		dicePart1Panel = new JPanel();
		dicePart1Panel.setLayout(new BoxLayout(dicePart1Panel, BoxLayout.Y_AXIS));
		dice1CheckBox.setAlignmentX((float)0.4);
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


		//***************create dice control paenl**************
		diceControlPanel = new JPanel();
		diceControlPanel.setLayout(new BoxLayout(diceControlPanel, BoxLayout.Y_AXIS));

		turnLabel = new JLabel("Turn: 0");
		rollLabel = new JLabel("Roll: 0");
		rollButton = new JButton("Roll");


		rollButton.setAlignmentX((float)0.5);
		rollLabel.setAlignmentX((float)0.5);
		turnLabel.setAlignmentX((float)0.5);

		diceControlPanel.add(turnLabel);
		diceControlPanel.add(rollLabel);
		diceControlPanel.add(rollButton);

//**********************RoLLButtonListener******************
		class RollButtonListener implements ActionListener
		{
//			public void actionPerformed(ActionEvent event)
//			{
//				int delay = 150;
//				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dice1.setCurrDiceNum();
						dice1.setImage(dice1.diceImages[dice1.getCurrDiceNum()]);
						System.out.println(dice1.getCurrDiceNum());
						for (ImagePanel imagePanel : imagePanelList) {
							imagePanel.setCurrDiceNum();
							imagePanel.setImage(imagePanel.diceImages[imagePanel.getCurrDiceNum()]);
							//imagePanel.repaint();
							//System.out.println("dicenum" + currDiceNum + "    panelnum:" + count);
							//imagePanel.repaint();
							//dicePart1Panel.repaint(200);

						}

					}
				}
//				Timer t = new Timer(delay, taskPerformer);
//				t.start();
//
//				class rollStopListener implements ActionListener {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						t.stop();
//					}
//				}
//				int randomTime = (int)(Math.random() * 3000);
//				Timer stop = new Timer(randomTime, new rollStopListener());
//				stop.start();
//
//			}
//		}

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
