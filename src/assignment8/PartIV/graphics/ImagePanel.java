package assignment8.PartIV.graphics;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
	private Image img;
	public int imgNum = 1;
	public int currdicenum = 1;


	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}
	
	public ImagePanel(Image img) {
		this.img = img;
        //Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		Dimension size = new Dimension(250,180);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
	}
    public void paintComponent(Graphics g) {
		g.drawImage(img, 50, 0, null);
		String[] stringSet = {"die1.png","die2.png","die3.png","die6.png","die5.png","die4.png"};
		currdicenum = imgNum;
		imgNum = (int) (Math.random() * 6 + 1);
		img =  new ImageIcon(stringSet[imgNum - 1]).getImage();
		System.out.println(imgNum);


    }




}
