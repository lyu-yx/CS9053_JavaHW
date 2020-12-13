//package finalproject.server;
//
//import java.sql.*;
//
//public class LoadGame {
//
//
//    public void QueryGame()
//    {
//        String url = "jdbc:sqlite:./database/Game.db";
//        try {
//            Connection connect = DriverManager.getConnection(url);
//            Statement select = connect.createStatement();
//            printAllData(select);
//            select.close();
//            connect.close();
//        }
//        catch (SQLException e) { System.out.println(e); }
//    }
//
//
//    private void printAllData(Statement stmt)
//    {
//        try {
//            ResultSet result;
//            String s = "SELECT player_name,date FROM Game";
//            result = stmt.executeQuery(s);
//            while(result.next()){
//                wordsBox.append(result.getString("player_name") + "    ");
//                wordsBox.append(result.getString("date"));
//                wordsBox.append("\n");
//            }
//
//            // in a complex SQL Query, results could come from multiple tables.
//            // but in this example the results only come from one table.
////            String tableName = rsmd.getTableName(1);
////            System.out.println("Table: " + tableName);
////            System.out.println("Last Names:");
//
//        } // try
//
//        catch (SQLException sql) { sql.printStackTrace(); }
//
//    }
//}
