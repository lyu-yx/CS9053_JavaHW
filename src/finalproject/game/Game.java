package finalproject.game;

import javax.swing.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Game implements Serializable {
    public int acesResult, twosResult, threesResult, foursResult,
            fivesResult, sixesResult, upperScoreSum, upperBonus, upperTotal; //9
    public int threeOfaKind, fourOfaKind, fullHouse, smallStraight,
            largeStraight, yahtzee, chance, yahtzeeBonus, lowerScoreSum, grandTotal; //10
    public boolean[] isOccupied = new boolean[13];//13
    public int currTurn, currRound;                    //2
    public List<Integer> imageSequence;               //5
    public List<JCheckBox> checkBoxesList;            //5
    public String userName;                           //2
    public String time;

    public Game() {
        acesResult = ComputeAlgorithms.acesResult;
        twosResult = ComputeAlgorithms.twosResult;
        threesResult = ComputeAlgorithms.threesResult;
        foursResult = ComputeAlgorithms.foursResult;
        fivesResult = ComputeAlgorithms.fivesResult;
        sixesResult = ComputeAlgorithms.sixesResult;

        upperScoreSum = ComputeAlgorithms.computeUpperScoreSum();
        upperBonus = ComputeAlgorithms.computeUpperBonus();
        upperTotal = ComputeAlgorithms.computeUpperTotal();

        threeOfaKind = ComputeAlgorithms.threeOfaKind;
        fourOfaKind = ComputeAlgorithms.fourOfaKind;
        fullHouse = ComputeAlgorithms.fullHouse;
        smallStraight = ComputeAlgorithms.smallStraight;
        largeStraight = ComputeAlgorithms.largeStraight;
        yahtzee = ComputeAlgorithms.yahtzee;
        chance = ComputeAlgorithms.chance;
        yahtzeeBonus = ComputeAlgorithms.yahtzeeBonus;
        lowerScoreSum = ComputeAlgorithms.lowerScoreSum;
        grandTotal = ComputeAlgorithms.grandTotal;


        isOccupied = ComputeAlgorithms.isOccupied;
        currRound = ImagePanel.currRound;
        currTurn = ImagePanel.currTurn;

        imageSequence = ImagePanel.imageSequence;
        checkBoxesList = ImagePanel.checkBoxesList;

        userName = PlayerNamePanel.getPlayerName();
        time = Calendar.getInstance().getTime().toString();
    }




}
