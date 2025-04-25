import javax.swing.*;
import java.awt.*;

public class DefensiveAiWinningMove {

    JButton[] gridSpaceButtons;

    private int oInLine = 0;
    private int emptySpace = 0;
    int winningMove = 0;

    private final int[][] combinations = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}};

    public DefensiveAiWinningMove(JButton[] gridSpaceButtons){
        this.gridSpaceButtons = gridSpaceButtons;
    }

    boolean aiWinningMove(int[] buttonHolder){

        for(int combI = 0; combI < 8; combI++){
            for(int combJ = 0; combJ < 3; combJ++){
                if(buttonHolder[combinations[combI][combJ]] == 0){
                    oInLine++;
                }
                else if(buttonHolder[combinations[combI][combJ]] == -1){
                    winningMove = combinations[combI][combJ];
                    emptySpace++;
                }
            }

            if(oInLine == 2 && emptySpace == 1){
                return true;
            }

            oInLine = 0;
            emptySpace = 0;

        }

        return false;
    }

    void giveMove(int spaceToGiveMove, Icon icon, int[] buttonHolder){
        gridSpaceButtons[spaceToGiveMove].setForeground(new Color(255, 0, 0));
        buttonHolder[spaceToGiveMove] = 0;
        gridSpaceButtons[spaceToGiveMove].setIcon(icon);
    }

}
