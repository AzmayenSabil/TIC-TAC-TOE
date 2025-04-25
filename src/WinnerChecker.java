import javax.swing.*;
import java.awt.*;

public class WinnerChecker {

    JButton[] gridSpaceButtons;
    int[] buttonHolder;
    PlayerWinnerChecker playerWinnerChecker;
    AiWinnerChecker aiWinnerChecker;

    void setGridSpaceButtons(JButton[] gridSpaceButtons, int[] buttonHolder){
        this.gridSpaceButtons = gridSpaceButtons;
        this.playerWinnerChecker = new PlayerWinnerChecker(gridSpaceButtons);
        this.aiWinnerChecker = new AiWinnerChecker(gridSpaceButtons);
        this.buttonHolder = buttonHolder;
    }

    boolean checkForPlayerWin() {

        if(playerWinnerChecker.checkIfPlayerWon(buttonHolder)){
            declareWinner(playerWinnerChecker.spaceOne, playerWinnerChecker.spaceTwo, playerWinnerChecker.spaceThree, "player");
            return true;
        }
        else{
            return false;
        }

    }

    boolean checkForAiWin(){

        if(aiWinnerChecker.checkIfAiWon(buttonHolder)){
            declareWinner(aiWinnerChecker.spaceOne, aiWinnerChecker.spaceTwo, aiWinnerChecker.spaceThree, "AI");
            return true;
        }
        else{
            return false;
        }
    }

    boolean checkForDraw(){

        int x = 0;
        int o = 0;

        for(int box = 0; box < 9; box++){
            if(buttonHolder[box] == 1){
                x++;
            }
            else if(buttonHolder[box] == 0){
                o++;
            }
        }

        if(x==5 && o==4){
            declareWinner(0,0,0,"draw");
            return true;
        }

        return false;
    }

    void declareWinner(int spaceOne, int spaceTwo, int spaceThree, String winner){

        if(winner.equals("draw")){
            new WinnerWindow("DRAW");
        }
        if(winner.equals("player")) {
            new WinnerWindow("YOU WON");
        }
        if(winner.equals("AI")) {
            new WinnerWindow("YOU LOST");
        }
        disableButtons();
        markWinningPositions(spaceOne, spaceTwo, spaceThree);
    }

    void disableButtons(){
        for (int box = 0; box < 9; box++) {
            gridSpaceButtons[box].setEnabled(false);
        }
    }

    void markWinningPositions(int spaceOne, int spaceTwo, int spaceThree){
        gridSpaceButtons[spaceOne].setBackground(Color.RED);
        gridSpaceButtons[spaceTwo].setBackground(Color.RED);
        gridSpaceButtons[spaceThree].setBackground(Color.RED);
    }

}

/*

0  |  1  |  2
-------------
3  |  4  |  5
-------------
6  |  7  |  8

*/
