package finalproject.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class QueryGamePanel extends JFrame {

    private JPanel topPanel; // the top line of objects is going to go here
    private JTextArea wordsBox; // results of the search go in here.
    private JLabel findLabel;
    private JTextField findField;
    private JButton clearButton, queryButton;

    private final static int AREA_ROWS = 10;
    private final static int AREA_COLUMNS = 30;
    JList list;
    private ResultSet resultSet;


    public QueryGamePanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(500, 300);
        JPanel panelForTextFields = new JPanel();
        panelForTextFields.setSize(400, 180);

        createFindField();
        createButton();
        add(createTopPanel(), BorderLayout.NORTH);

        creatTextArea();
        JScrollPane scrollPane = new JScrollPane(wordsBox);
        add(scrollPane);

    }


    public void createButton()
    {
        clearButton = new JButton("Clear");
        queryButton = new JButton("Query");

    class AddInterestListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            findField.setText("");
            findField.setCaretPosition(0);
            }
        }
        ActionListener listener = new AddInterestListener();
        clearButton.addActionListener(listener);


    class QueryButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            QueryGame();
        }
    }
        ActionListener queryListener = new QueryButtonListener();
        queryButton.addActionListener(queryListener);
    }

    public void createFindField()
    {
        findLabel = new JLabel("Find: ");
        final int FIELD_WIDTH = 10;
        findField = new JTextField(FIELD_WIDTH);
        findField.setText("");

    }

    public JPanel createTopPanel() {
        topPanel = new JPanel();
        topPanel.add(findLabel);
        topPanel.add(findField);
        topPanel.add(clearButton);
        topPanel.add(queryButton);

        add(topPanel);
        return topPanel;
    }

//############################   Text Area Part   ########################################
    public void creatTextArea() {
        wordsBox = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        wordsBox.setEditable(false);

    }


    public void QueryGame()
    {
        String url = "jdbc:sqlite:./database/Game.db";
        try {
            Connection connect = DriverManager.getConnection(url);
            Statement select = connect.createStatement();
            printAllData(select);
            select.close();
            connect.close();
        }
        catch (SQLException e) { System.out.println(e); }
    }


    private void printAllData(Statement stmt)
    {
        try {
            ResultSet result;
            String s = "SELECT player_name,date FROM Game";
            result = stmt.executeQuery(s);
            while(result.next()){
                wordsBox.append(result.getString("player_name") + "    ");
                wordsBox.append(result.getString("date"));
                wordsBox.append("\n");
            }
        }
        catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

}
