package finalproject.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveGame {

    Connection con;
    PreparedStatement insertStatement;
    public SaveGame() {
        try
        {
            //Connect to a database
            this.con = DriverManager.getConnection
                    ("jdbc:sqlite:./database/Game.db");
        } catch (Exception e) {
            System.exit(0);
        }

        /* sets up the prepared statement for SQL inserts */
        String insertSQL = "Insert into GAME (player_name, aces, twos, threes, fours, fives, sixes," +
                "upper_sum, upper_bonus, upper_total, three_of_kind, four_of_kind, full_house," +
                "small_straight, large_straight, yahtzee, yahtzee_bonus, lower_sum, grand_total," +
                "dice1_cur_num, dice2_cur_num, dice3_cur_num, dice4_cur_num, dice5_cur_num," +
                "dice1_checkbox, dice2_checkbox , dice3_checkbox , dice4_checkbox , dice5_checkbox," +
                "aces_select, twos_select, threes_select," +
                "fours_select, fives_select, sixes_select," +
                "three_of_kind_select, four_of_kind_select, full_house_select," +
                "small_straight_select, large_straight_select, yahtzee_select) " +
                "Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        try {
            insertStatement = con.prepareStatement(insertSQL);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }




    public void insertData(){
//        try
//        {
//
//            insertStatement.setString(1, PlayerNamePanel.);
//            insertStatement.setInt(2, ComputeAlgorithms.acesResult);
//            insertStatement.setString(3, txtAddress.getText());
//            insertStatement.setString(4, txtSalary.getText());
//            insertStatement.execute();
//
//            createMessageBox("Inserted Successfully");
//            clearControls();
//        }
//        catch(Exception e)
//        {
//            createMessageBox(e.getMessage());
//        }
    }
}
