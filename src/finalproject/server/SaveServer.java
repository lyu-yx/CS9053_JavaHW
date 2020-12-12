package finalproject.server;


import finalproject.game.Game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class SaveServer extends JFrame {

	private JTextArea wordsBox = new JTextArea();
	private byte[] buf = new byte[1024];
	Connection con;
	PreparedStatement insertStatement;



	public SaveServer() {
		createMainPanel();
		wordsBox.append("Ready to Accept Connections" + '\n');
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setVisible(true);

		try {
			// Create a server saveGameSocket
			ServerSocket serverSocket = new ServerSocket(8000);
//			DatagramSocket saveSocket = new DatagramSocket(9000);
			wordsBox.append("Server started at " + new Date() + '\n');
//			// Create a packet for receiving data
//			DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
//			// Create a packet for sending data
//			DatagramPacket sendPacket =	new DatagramPacket(buf, buf.length);




			while (true) {
//				// Initialize buffer for each iteration
//				Arrays.fill(buf, (byte)0);
//				// Receive radius from the client in a packet
//				saveSocket.receive(receivePacket);
//				wordsBox.append("The client host name is " +
//						receivePacket.getAddress().getHostName() +
//						" and port number is " + receivePacket.getPort() + '\n');
//				wordsBox.append("Command received " +
//						new String(buf).trim() +  '\n');

				// Compute area
//				double radius = Double.parseDouble(new String(buf).trim());
//				double area = radius * radius * Math.PI;
//				wordsBox.append("Area is " + area + '\n');
				Socket socket = serverSocket.accept();
				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
				Game game = (Game) objectInputStream.readObject();
				System.out.println(game.time);
				SaveGame saveGame = new SaveGame();

				saveGame.insertData(game);
				wordsBox.append("Insert success at " + new Date() + '\n');
			}
		}
		catch(IOException | ClassNotFoundException ex) {
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
