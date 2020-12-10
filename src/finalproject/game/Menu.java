package finalproject.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//#############################   Menu Part   ################################################

    public class Menu {
        public JMenu createFileMenu()
        {
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
        class LoadGameListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

            }
        }
        ActionListener listener = new LoadGameListener();
        item.addActionListener(listener);
        return item;
    }

}