package finalproject.server;

import finalproject.game.Game;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveGame {

    Connection con;
    PreparedStatement insertStatement;
    //**************************************constructor**************************************
    //prepare for the connection
    public SaveGame() {
        try
        {
            //Connect to a database
            this.con = DriverManager.getConnection("jdbc:sqlite:./database/Game.db");
        } catch (Exception e) {
            System.exit(0);
        }

        /* sets up the prepared statement for SQL inserts */
        String insertSQL = "Insert into Game (player_name, date, aces, twos, threes, fours, fives, sixes," +
                "upper_sum, upper_bonus, upper_total, three_of_kind, four_of_kind, full_house," +
                "small_straight, large_straight, yahtzee, chance, yahtzee_bonus, lower_sum, grand_total," +
                "dice1_cur_num, dice2_cur_num, dice3_cur_num, dice4_cur_num, dice5_cur_num," +
                "dice1_checkbox, dice2_checkbox , dice3_checkbox , dice4_checkbox , dice5_checkbox," +
                "aces_select, twos_select, threes_select," +
                "fours_select, fives_select, sixes_select," +
                "three_of_kind_select, four_of_kind_select, full_house_select," +
                "small_straight_select, large_straight_select, yahtzee_select, chance_select, cur_round, curr_turn)" +
                " Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            insertStatement = con.prepareStatement(insertSQL);
        } catch (SQLException e) {
            e.printStackTrace();
            //System.exit(0);
        }

    }


//**************************************insert data**************************************

    public void insertData(Game game){
        try
        {
            //2
            insertStatement.setString(1, game.userName);//
            insertStatement.setString(2, game.time);
            //upper 9
            insertStatement.setInt(3, game.acesResult);
            insertStatement.setInt(4, game.twosResult);
            insertStatement.setInt(5, game.threesResult);
            insertStatement.setInt(6, game.foursResult);
            insertStatement.setInt(7, game.fivesResult);
            insertStatement.setInt(8, game.sixesResult);
            insertStatement.setInt(9, game.upperScoreSum);
            insertStatement.setInt(10, game.upperBonus);
            insertStatement.setInt(11, game.upperTotal);
            //lower 10
            insertStatement.setInt(12, game.threeOfaKind);
            insertStatement.setInt(13, game.fourOfaKind);
            insertStatement.setInt(14, game.fullHouse);
            insertStatement.setInt(15, game.smallStraight);
            insertStatement.setInt(16, game.largeStraight);
            insertStatement.setInt(17, game.yahtzee);
            insertStatement.setInt(18, game.chance);
            insertStatement.setInt(19, game.yahtzeeBonus);
            insertStatement.setInt(20, game.lowerScoreSum);
            insertStatement.setInt(21, game.grandTotal);
            //5
            insertStatement.setInt(22, game.imageSequence.get(0));
            insertStatement.setInt(23, game.imageSequence.get(1));
            insertStatement.setInt(24, game.imageSequence.get(2));
            insertStatement.setInt(25, game.imageSequence.get(3));
            insertStatement.setInt(26, game.imageSequence.get(4));
            //5
            insertStatement.setInt(27, game.checkBoxesList.get(0).isSelected() ? 1 : 0);
            insertStatement.setInt(28, game.checkBoxesList.get(1).isSelected() ? 1 : 0);
            insertStatement.setInt(29, game.checkBoxesList.get(2).isSelected() ? 1 : 0);
            insertStatement.setInt(30, game.checkBoxesList.get(3).isSelected() ? 1 : 0);
            insertStatement.setInt(31, game.checkBoxesList.get(4).isSelected() ? 1 : 0);
            //13
            insertStatement.setInt(32, game.isOccupied[0] ? 1 : 0);
            insertStatement.setInt(33, game.isOccupied[1] ? 1 : 0);
            insertStatement.setInt(34, game.isOccupied[2] ? 1 : 0);
            insertStatement.setInt(35, game.isOccupied[3] ? 1 : 0);
            insertStatement.setInt(36, game.isOccupied[4] ? 1 : 0);
            insertStatement.setInt(37, game.isOccupied[5] ? 1 : 0);
            insertStatement.setInt(38, game.isOccupied[6] ? 1 : 0);
            insertStatement.setInt(39, game.isOccupied[7] ? 1 : 0);
            insertStatement.setInt(40, game.isOccupied[8] ? 1 : 0);
            insertStatement.setInt(41, game.isOccupied[9] ? 1 : 0);
            insertStatement.setInt(42, game.isOccupied[10] ? 1 : 0);
            insertStatement.setInt(43, game.isOccupied[11] ? 1 : 0);
            insertStatement.setInt(44, game.isOccupied[12] ? 1 : 0);

            insertStatement.setInt(45, game.currRound);
            insertStatement.setInt(46, game.currTurn);


            insertStatement.execute();

            //createMessageBox("Inserted Successfully");

        }
        catch(Exception e)
        {
            createMessageBox(e.getMessage());
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
}
