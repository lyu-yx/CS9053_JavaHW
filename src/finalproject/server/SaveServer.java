package finalproject.server;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Date;

public class SaveServer extends JFrame {

	private JTextArea wordsBox = new JTextArea();
	private byte[] buf = new byte[256];
	public SaveServer() {
		createMainPanel();
		wordsBox.append("Ready to Accept Connections" + '\n');
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setVisible(true);

		try {
			// Create a server socket
			DatagramSocket socket = new DatagramSocket(8001);
			wordsBox.append("Server started at " + new Date() + '\n');
			// Create a packet for receiving data
			DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
			// Create a packet for sending data
			DatagramPacket sendPacket =	new DatagramPacket(buf, buf.length);

			while (true) {
				// Initialize buffer for each iteration
				Arrays.fill(buf, (byte)0);

				// Receive radius from the client in a packet
				socket.receive(receivePacket);
				wordsBox.append("The client host name is " +
						receivePacket.getAddress().getHostName() +
						" and port number is " + receivePacket.getPort() + '\n');
				wordsBox.append("Radius received from client is " +
						new String(buf).trim() +  '\n');

				// Compute area
				double radius = Double.parseDouble(new String(buf).trim());
				double area = radius * radius * Math.PI;
				wordsBox.append("Area is " + area + '\n');

				// Send area to the client in a packet
				sendPacket.setAddress(receivePacket.getAddress());
				sendPacket.setPort(receivePacket.getPort());
				sendPacket.setData(new Double(area).toString().getBytes());
				socket.send(sendPacket);
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}










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
