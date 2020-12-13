package finalproject.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;

//#############################   Menu Part   ################################################

    public class Menu {
        Connection con;
        PreparedStatement insertStatement;
        private byte[] buf = new byte[1024];
        private DatagramPacket sendPacket, receivePacket;
        DatagramSocket socket;


//        public Menu(YahtzeeFrame yahtzeeFrame) {
////            this.yahtzeeFrame = yahtzeeFrame;
//        }



        public JMenu createFileMenu()
        {
            try {
                // get a datagram socket
                socket = new DatagramSocket();
                InetAddress address = InetAddress.getByName("localhost");
                sendPacket = new DatagramPacket(buf, buf.length, address, 8000);
                receivePacket = new DatagramPacket(buf, buf.length);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }

            JMenu menu = new JMenu("Game");
            menu.add(createGameLoad());
            menu.add(createGameSave());
            menu.add(createFileExitItem());
            return menu;
        }

        /**
         Creates the Game->Exit menu item and sets its action listener.
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
         Creates the Game->Load Game menu item and sets its action listener.
         @return the menu item
         */
        public JMenuItem createGameLoad()
        {
            JMenuItem item = new JMenuItem("Load Game");
            class LoadGameListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Socket socket = new Socket("localhost", 9000);
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                        out.writeInt(1);
                        out.flush();

                        ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
                        Game game = (Game) fromServer.readObject();
                        ComputeAlgorithms.acesResult = game.acesResult;
                        ComputeAlgorithms.twosResult = game.twosResult;
                        ComputeAlgorithms.threesResult = game.threesResult;
                        ComputeAlgorithms.foursResult = game.foursResult;
                        ComputeAlgorithms.fivesResult = game.fivesResult;
                        ComputeAlgorithms.sixesResult = game.sixesResult;
                        ComputeAlgorithms.upperScoreSum = game.upperScoreSum;
                        ComputeAlgorithms.upperBonus = game.upperBonus;
                        ComputeAlgorithms.upperTotal = game.upperTotal;
                        ComputeAlgorithms.threeOfaKind = game.threeOfaKind;
                        ComputeAlgorithms.fourOfaKind = game.fourOfaKind;
                        ComputeAlgorithms.fullHouse = game.fullHouse;
                        ComputeAlgorithms.smallStraight = game.smallStraight;
                        ComputeAlgorithms.largeStraight = game.largeStraight;
                        ComputeAlgorithms.yahtzee = game.yahtzee;
                        ComputeAlgorithms.yahtzeeBonus = game.yahtzeeBonus;
                        ComputeAlgorithms.chance = game.chance;
                        ComputeAlgorithms.lowerScoreSum = game.lowerScoreSum;
                        ComputeAlgorithms.grandTotal = game.grandTotal;
//                        ImagePanel.imageSequence.set(0, game.diceNum[0]);
//                        ImagePanel.imageSequence.set(1, game.diceNum[1]);
//                        ImagePanel.imageSequence.set(2, game.diceNum[2]);
//                        ImagePanel.imageSequence.set(3, game.diceNum[3]);
//                        ImagePanel.imageSequence.set(4, game.diceNum[4]);
//                        ImagePanel.imagePanelList.get(1).setSpecificDiceNum(game.imageSequence.get(1));
//                        ImagePanel.imagePanelList.get(2).setSpecificDiceNum(game.imageSequence.get(2));
//                        ImagePanel.imagePanelList.get(3).setSpecificDiceNum(game.imageSequence.get(3));
//                        ImagePanel.imagePanelList.get(4).setSpecificDiceNum(game.imageSequence.get(4));

                        ComputeAlgorithms.isOccupied = game.isOccupied;

                        ImagePanel.currRound = game.currRound;
                        ImagePanel.currTurn = game.currTurn;
                    ComputeAlgorithms.resetAll();
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }

                }
            }
            ActionListener listener = new LoadGameListener();
            item.addActionListener(listener);
            return item;
        }





    /**
     Creates the Game->Save Game menu item and sets its action listener.
     @return the menu item
     */
    public JMenuItem createGameSave()
    {
        JMenuItem item = new JMenuItem("Save Game");

        class SaveGameListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
              try {
                    Socket socket = new Socket("localhost", 8000);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    Game game = new Game();
                    out.writeObject(game);
                    out.flush();
                    out.close();
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        }
        ActionListener listener = new SaveGameListener();
        item.addActionListener(listener);
        return item;
    }



}