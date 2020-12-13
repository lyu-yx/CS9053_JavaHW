package finalproject.server;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class LoadServer extends JFrame{

    private JComboBox facenameCombo;
    private ActionListener listener;

    public LoadServer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setVisible(true);

        try {
            ServerSocket serverSocket = new ServerSocket(9000);

            while(true) {
                Socket socket = serverSocket.accept();
                DataInputStream command = new DataInputStream(socket.getInputStream());
                int flag = command.readInt();
                if (flag == 1) {
                    createMainPanel();
                    this.setVisible(true);
                }
            }




        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public JPanel createComboBox() throws SQLException {
        facenameCombo = new JComboBox();
        String url = "jdbc:sqlite:./database/Game.db";
        Connection connect = DriverManager.getConnection(url);
        Statement select = connect.createStatement();
        ResultSet result;
        String s = "SELECT player_name,date FROM Game";
        result = select.executeQuery(s);
        while(result.next()) {
            facenameCombo.addItem(result.getString("player_name") + "   " + result.getString("date"));
        }
        JPanel panel = new JPanel();
        panel.add(facenameCombo);
        return panel;
    }




    public void createMainPanel() {
        try {
            this.add(createComboBox());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] main) {
        LoadServer loadServer = new LoadServer();
    }

}

