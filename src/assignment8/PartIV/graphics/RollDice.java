package assignment8.PartIV.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RollDice extends JFrame {

	//private JTextField findField;
	private JButton rollDiceButton;
	private ImagePanel imagePanel1;
	private ImagePanel imagePanel2;
	private JLabel sumLabel;
	public static int sum = 2;



	public RollDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupPanels();

		setSize(800,600);
		setVisible(true);



	}




	public void setupPanels() {
		JPanel mainPanel = new JPanel();
		JPanel resultPanel = createResult();
		JPanel sumResultPanel = createSumResult();
		JPanel bottonPanel = createButton();

		// Line up component panels
		mainPanel.setLayout(new GridLayout(3, 1));
		mainPanel.add(resultPanel);
		mainPanel.add(sumResultPanel);
		mainPanel.add(bottonPanel);

		// Add panels to content pane
		add(mainPanel);
	}


	public JPanel createResult() {
		JPanel resultPanel = new JPanel();
		imagePanel1 = new ImagePanel("die1.png");
		imagePanel2 = new ImagePanel("die1.png");
		resultPanel.add(imagePanel1);
		resultPanel.add(imagePanel2);


		class mouseClickListener1 implements MouseListener {
			@Override
			public void mouseClicked(MouseEvent e) {

				int delay = 150;
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						imagePanel1.repaint(200);
						sum = imagePanel1.imgNum + imagePanel2.currdicenum;
						sumLabel.setText("Result: " + sum);
					}
				};
				Timer t = new  Timer(delay, taskPerformer);
				t.start();

				class rollStopListener implements ActionListener {
					@Override
					public void actionPerformed(ActionEvent e) {
						t.stop();
					}
				}
				int randomTime = (int)(Math.random() * 3000);
				Timer stop = new Timer(randomTime, new rollStopListener());
				stop.start();


			}
			@Override
			public void mousePressed(MouseEvent e) {

			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		}

		class mouseClickListener2 implements MouseListener {
			@Override
			public void mouseClicked(MouseEvent e) {

				int delay = 150;
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						sum = imagePanel1.currdicenum + imagePanel2.imgNum;
						//imagePanel1.repaint(200);
						imagePanel2.repaint(200);
						sumLabel.setText("Result: " + sum);
					}
				};
				Timer t = new  Timer(delay, taskPerformer);
				t.start();

				class rollStopListener implements ActionListener {
					@Override
					public void actionPerformed(ActionEvent e) {
						t.stop();
					}
				}
				int randomTime = (int)(Math.random() * 3000);
				Timer stop = new Timer(randomTime, new rollStopListener());
				stop.start();



//				imagePanel2.repaint(200);
//				sum = imagePanel1.currdicenum + imagePanel2.imgNum;
//				sumLabel.setText("Result: " + sum);
			}
			@Override
			public void mousePressed(MouseEvent e) {

			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		}
		MouseListener listener1 = new mouseClickListener1();
		MouseListener listener2 = new mouseClickListener2();
		imagePanel1.addMouseListener(listener1);
		imagePanel2.addMouseListener(listener2);
		resultPanel.add(imagePanel1);
		resultPanel.add(imagePanel2);



		return  resultPanel;
	}


	public JPanel createSumResult() {
		JPanel sumResultPanel = new JPanel();
		sumLabel = new JLabel("Result: " + sum);
		sumResultPanel.add(sumLabel);
		return  sumResultPanel;
	}



	public JPanel createButton()
	{
		JPanel buttonResult = new JPanel();
		rollDiceButton = new JButton("Roll Dice");
		class AddInterestListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{

				int delay = 150;
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						sum = imagePanel1.imgNum + imagePanel2.imgNum;
						imagePanel1.repaint(200);
						imagePanel2.repaint(200);
						sumLabel.setText("Result: " + sum);
					}
				};
				Timer t = new  Timer(delay, taskPerformer);
				t.start();

				class rollStopListener implements ActionListener {
					@Override
					public void actionPerformed(ActionEvent e) {
						t.stop();
					}
				}
				int randomTime = (int)(Math.random() * 3000);
				Timer stop = new Timer(randomTime, new rollStopListener());
				stop.start();

			}
		}
		ActionListener listener = new AddInterestListener();
		rollDiceButton.addActionListener(listener);
		buttonResult.add(rollDiceButton);
		return buttonResult;
	}




	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	}
}
