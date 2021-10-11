import javax.swing.*;

public class PlayerWinnerChecker {

    JButton[] gridSpaceButtons;

    int spaceOne = -1;
    int spaceTwo = -1;
    int spaceThree = -1;
    int playerInLineCount = 0;

    private final int[][] combinations = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}};

    public PlayerWinnerChecker(JButton[] gridSpaceButtons){
        this.gridSpaceButtons = gridSpaceButtons;
    }

    boolean checkIfPlayerWon(int[] buttonHolder){

        for(int combI = 0; combI < 8; combI++){
            for(int combJ = 0; combJ < 3; combJ++){
                if(buttonHolder[combinations[combI][combJ]] == 1){
                    playerInLineCount++;
                }
                if(playerInLineCount == 3){
                    spaceOne = combinations[combI][0];
                    spaceTwo = combinations[combI][1];
                    spaceThree = combinations[combI][2];
                    return true;
                }
            }
            playerInLineCount = 0;

        }

        return false;
    }

}
