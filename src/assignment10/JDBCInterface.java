package assignment10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class JDBCInterface extends JFrame {

	private JPanel controlPanel, insertPanel, mainInsertPanel;
	private JTextArea textQueryArea;
	private JTextField lastNameQuery, firstNameInsert, lastNameInsert, ageInsert, cityInsert;
	private JButton queryButton, insertButton;
	
	private Connection conn;
	private PreparedStatement queryStmtLastName, queryStmtLastNameNull, insertStatement;
	
	
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 500;
	final int AREA_ROWS = 20;
	final int AREA_COLUMNS = 40;
   
   public JDBCInterface() {

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:./database/assignment.db");
			queryStmtLastName = conn.prepareStatement("Select * from People WHERE Last = ?");
			
		} catch (SQLException e) {
			System.err.println("Connection error: " + e);
			System.exit(1);
		}

	   String insertSQL = "Insert Into People (First, last, age, city) " +
			   "Values (?,?,?,?)";
	   try {
		   insertStatement = conn.prepareStatement(insertSQL);
	   } catch (SQLException e) {
		   e.printStackTrace();
		   System.exit(0);
	   }

	   try {
		   queryStmtLastNameNull = conn.prepareStatement("Select * from People");
	   } catch (SQLException e) {
		   e.printStackTrace();
		   System.exit(0);
	   }


	   mainInsertPanel = createInsertPanel();
	   createControlPanel();
	   queryButton.addActionListener(new QueryButtonListener());
	   insertButton.addActionListener(new insertButtonListener());
	   textQueryArea = new JTextArea(
	            AREA_ROWS, AREA_COLUMNS);
	   textQueryArea.setEditable(false);
	   
	   /* scrollPanel is optional */
	   JScrollPane scrollPane = new JScrollPane(textQueryArea);
	   JPanel textPanel = new JPanel();
	   textPanel.add(scrollPane);



	   JPanel lowerLayoutPanel = new JPanel();

	   lowerLayoutPanel.add(controlPanel, BorderLayout.SOUTH);
	   lowerLayoutPanel.add(textPanel, BorderLayout.CENTER);
	   this.add(mainInsertPanel, BorderLayout.NORTH);
	   this.add(lowerLayoutPanel, BorderLayout.SOUTH);
	   //this.add(textPanel);
	   // this.add(controlPanel, BorderLayout.CENTER);
	   //this.add(textPanel);
	   //
//	   mainPanel.add(insertPanel, BorderLayout.BEFORE_FIRST_LINE);
//	   mainPanel.add(textPanel, BorderLayout.SOUTH);
//	   mainPanel.add(controlPanel, BorderLayout.NORTH);
   }

	private JPanel createInsertPanel() {
		JPanel mainInsertPanel = new JPanel(new GridLayout(2,1));

   		insertPanel = new JPanel(new GridLayout(2,4));
		JLabel firstNameLabel, lastNameLabel, ageLabel, cityLabel;


		insertButton = new JButton("Insert");
		firstNameLabel = new JLabel("First Name");
		lastNameLabel = new JLabel("Last Name:");
		ageLabel = new JLabel("Age");
		cityLabel = new JLabel("City");

		firstNameInsert = new JTextField(10);
		lastNameInsert = new JTextField(10);
		ageInsert = new JTextField(10);
		cityInsert = new JTextField(10);

		insertPanel.add(firstNameLabel);
		insertPanel.add(firstNameInsert);

		insertPanel.add(lastNameLabel);
		insertPanel.add(lastNameInsert);

		insertPanel.add(ageLabel);
		insertPanel.add(ageInsert);

		insertPanel.add(cityLabel);
		insertPanel.add(cityInsert);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(insertButton);


		mainInsertPanel.add(insertPanel, BorderLayout.NORTH);
		mainInsertPanel.add(buttonPanel, BorderLayout.SOUTH);


   		return mainInsertPanel;
	}



   private JPanel createControlPanel() {
	   /* you are going to have to create a much more fully-featured layout */
	   controlPanel = new JPanel();
	   
	   JPanel inputPanel = new JPanel();
	   JLabel lbl = new JLabel("Last Name:");
	   inputPanel.add(lbl);
	   lastNameQuery = new JTextField(10);
	   inputPanel.add(lastNameQuery);
	   
	   JPanel buttonPanel = new JPanel();
	   queryButton = new JButton("Execute Query");
	   buttonPanel.add(queryButton);
	   
	   controlPanel.add(inputPanel);
	   controlPanel.add(buttonPanel);
	   
	   return controlPanel;
	   
	   
   }
   
   class insertButtonListener implements ActionListener {
	   public void actionPerformed(ActionEvent event) {
		   /* You will have to implement this */
		   try
		   {
			   if (firstNameInsert.getText().equals("") || lastNameInsert.getText().equals("")
					|| ageInsert.getText().equals("") || cityInsert.getText().equals(""))
			   {
				   createMessageBox("All Fields must be filled");
				   clearControls();
				   return;
			   }
			   insertStatement.setString(1, firstNameInsert.getText());
			   insertStatement.setString(2, lastNameInsert.getText());
			   insertStatement.setString(3, ageInsert.getText());
			   insertStatement.setString(4, cityInsert.getText());
			   insertStatement.execute();

			   createMessageBox("Inserted Successfully");
			   clearControls();
		   }
		   catch(Exception e)
		   {
			   createMessageBox(e.getMessage());
		   }
	   }
   }


   
   class QueryButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event)
        {
		   /* as far as the columns, it is totally acceptable to
			* get all of the column data ahead of time, so you only
			* have to do it once, and just reprint the string
			* in the text area.
		    */
		   
		   /* you want to change things here so that if the text of the 
		    * last name query field is empty, it should query for all rows.
		    * 
		    * For now, if the last name query field is blank, it will execute:
		    * SELECT * FROM People WHERE Last=''
		    * which will give no results
		    */
		   try {
				textQueryArea.setText("");
				PreparedStatement stmt;

			    String lastNameText = lastNameQuery.getText();

			    if (lastNameText.equals("")) {
					stmt = queryStmtLastNameNull;
				} else {
					stmt = queryStmtLastName;
					stmt.setString(1, lastNameText);
				}



				ResultSet rset = stmt.executeQuery();
				ResultSetMetaData rsmd = rset.getMetaData();

				int numColumns = rsmd.getColumnCount();
//				System.out.println("numcolumns is "+ numColumns);


				String rowString = "";

			   for (int i = 1; i <= numColumns; i++) {
				   Object o = rsmd.getColumnName(i);
				   rowString += o.toString() + "\t";
			   }
			   rowString += "\n";


				while (rset.next()) {
					for (int i=1;i<=numColumns;i++) {
						Object o = rset.getObject(i);
						rowString += o.toString() + "\t";
					}
					rowString += "\n";
				}
				System.out.print("rowString  is  " + rowString);
				textQueryArea.setText(rowString);
		   } catch (SQLException e) {

			   e.printStackTrace();
		   }
        }
   }


	private void createMessageBox(String msg)
	{
		JFrame frame = new JFrame("Result");
		JLabel lbl = new JLabel(msg);
		frame.add(lbl);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
	private void clearControls()
	{
		String empty = "";

		firstNameInsert.setText(empty);
		lastNameInsert.setText(empty);
		ageInsert.setText(empty);
		cityInsert.setText(empty);

		textQueryArea.setText(empty);

	}



   public static void main(String[] args)
	{  
	   JFrame frame = new JDBCInterface();
	   frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setVisible(true);      
	}
}
