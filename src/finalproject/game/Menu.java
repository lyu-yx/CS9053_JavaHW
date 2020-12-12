package finalproject.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
                    QueryGamePanel queryGamePanel = new QueryGamePanel();
                    queryGamePanel.setVisible(true);

                    queryGamePanel.QueryGame();
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