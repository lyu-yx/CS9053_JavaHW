package assignment10;

import java.sql.*;

public class JDBCExample {

	private static String url;

	public static void main(String args[])

	{
		new JDBCExample ();

	}

	public JDBCExample()

	{

		url = "jdbc:sqlite:./database/assignment.db";
		try {

			Connection connect = DriverManager.getConnection(url);

			Statement select = connect.createStatement();

			printAllData(select);

			select.close();

			connect.close(); }

		catch (SQLException e) { System.out.println(e); }

	}

	private void printAllData(Statement stmt)

	{

		try {

			ResultSet result;

			String s = "SELECT * FROM People";

			result = stmt.executeQuery(s);

			ResultSetMetaData rsmd = result.getMetaData(); 

			// in a compplex SQL Query, results could come from multiple tables. 
			// but in this example the results only come from one table.
			String tableName = rsmd.getTableName(1); 
			System.out.println("Table: " + tableName);
			System.out.println("Last Names:");
			
			while (result.next())

			{

				System.out.println(result.getString(1));

			}


		} // try

		catch (SQLException sql) { sql.printStackTrace(); }

	}

}