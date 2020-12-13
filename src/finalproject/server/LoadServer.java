package finalproject.server;

import finalproject.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class LoadServer extends JFrame{

    private JComboBox loadGameCombo;
    private JButton loadGame;
    private Socket socket;

    public LoadServer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setVisible(true);

        try {
            ServerSocket serverSocket = new ServerSocket(9000);

            while(true) {
                socket = serverSocket.accept();

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

    public class LoadButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nameTime = (String)loadGameCombo.getSelectedItem();
            ResultSet result;
            Statement select;
            String url = "jdbc:sqlite:./database/Game.db";
            Connection connect = null;
            try {
                connect = DriverManager.getConnection(url);
                select = connect.createStatement();
                String[] split = nameTime.split(",");
                String gameTime = split[1];
                String s = "SELECT * FROM Game WHERE date=" + "'" + gameTime + "'";
                result = select.executeQuery(s);


                Game returnGame = new Game();
                returnGame.userName = result.getString(1);
                returnGame.acesResult = result.getInt(3);
                returnGame.twosResult = result.getInt(4);
                returnGame.threesResult = result.getInt(5);
                returnGame.foursResult = result.getInt(6);
                returnGame.fivesResult = result.getInt(7);
                returnGame.sixesResult = result.getInt(8);
                returnGame.upperScoreSum = result.getInt(9);
                returnGame.upperBonus = result.getInt(10);
                returnGame.upperTotal = result.getInt(11);
                returnGame.threeOfaKind = result.getInt(12);
                returnGame.fourOfaKind = result.getInt(13);
                returnGame.fullHouse = result.getInt(14);
                returnGame.smallStraight = result.getInt(15);
                returnGame.largeStraight = result.getInt(16);
                returnGame.yahtzee = result.getInt(17);
                returnGame.chance = result.getInt(18);
                returnGame.yahtzeeBonus = result.getInt(19);
                returnGame.lowerScoreSum = result.getInt(20);
                returnGame.grandTotal = result.getInt(21);
                returnGame.diceNum[0] = result.getInt(22);
                returnGame.diceNum[1] = result.getInt(23);
                returnGame.diceNum[2] = result.getInt(24);
                returnGame.diceNum[3] = result.getInt(25);
                returnGame.diceNum[4] = result.getInt(26);
//                returnGame.checkBoxesList.get(0).setSelected(result.getInt(27) == 1 ? true : false);
//                returnGame.checkBoxesList.get(1).setSelected(result.getInt(28) == 1 ? true : false);
//                returnGame.checkBoxesList.get(2).setSelected(result.getInt(29) == 1 ? true : false);
//                returnGame.checkBoxesList.get(3).setSelected(result.getInt(30) == 1 ? true : false);
//                returnGame.checkBoxesList.get(4).setSelected(result.getInt(31) == 1 ? true : false);
                returnGame.isOccupied[0] = result.getInt(32) == 1 ? true : false;
                returnGame.isOccupied[1] = result.getInt(33) == 1 ? true : false;
                returnGame.isOccupied[2] = result.getInt(34) == 1 ? true : false;
                returnGame.isOccupied[3] = result.getInt(35) == 1 ? true : false;
                returnGame.isOccupied[4] = result.getInt(36) == 1 ? true : false;
                returnGame.isOccupied[5] = result.getInt(37) == 1 ? true : false;
                returnGame.isOccupied[6] = result.getInt(38) == 1 ? true : false;
                returnGame.isOccupied[7] = result.getInt(39) == 1 ? true : false;
                returnGame.isOccupied[8] = result.getInt(40) == 1 ? true : false;
                returnGame.isOccupied[9] = result.getInt(41) == 1 ? true : false;
                returnGame.isOccupied[10] = result.getInt(42) == 1 ? true : false;
                returnGame.isOccupied[11] = result.getInt(43) == 1 ? true : false;
                returnGame.isOccupied[12] = result.getInt(44) == 1 ? true : false;
                returnGame.currRound = result.getInt(45);
                returnGame.currTurn = result.getInt(46);



                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(returnGame);
                Socket socket = new Socket("localhost", 9000);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    public JPanel createComboBox() throws SQLException {
        loadGameCombo = new JComboBox();
        String url = "jdbc:sqlite:./database/Game.db";
        Connection connect = DriverManager.getConnection(url);
        Statement select = connect.createStatement();
        ResultSet result;
        String s = "SELECT player_name,date FROM Game";
        result = select.executeQuery(s);
        while(result.next()) {
            loadGameCombo.addItem(result.getString("player_name") + "," + result.getString("date"));
        }
        JPanel panel = new JPanel();
        panel.add(loadGameCombo);
        return panel;
    }




    public void createMainPanel() {
        try {
            this.setLayout(new BorderLayout());
            this.add(createComboBox(), BorderLayout.NORTH);
            loadGame = new JButton("Load Game");
            LoadButtonListener loadButtonListener = new LoadButtonListener();
            loadGame.addActionListener(loadButtonListener);
            this.add(loadGame, BorderLayout.SOUTH);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] main) {
        LoadServer loadServer = new LoadServer();
    }

}

