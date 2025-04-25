import javax.swing.*;

public class DefensiveAI{

    JButton[] gridSpaceButtons;
    int aiMoveCount = 0;
    String oImagePath;
    Icon icon;

    RandomAI randomAI = new RandomAI();

    private DefensiveAiWinningMove defensiveAiWinningMove;
    private DefensiveAiBlockingMove defensiveAiBlockingMove;

    public void setOImagePath(String oImagePath){
        this.oImagePath = oImagePath;
        icon = new ImageIcon(oImagePath);
    }

    void setGridSpaceButtons(JButton[] gridSpaceButtons){
        this.gridSpaceButtons = gridSpaceButtons;
        this.defensiveAiWinningMove = new DefensiveAiWinningMove(gridSpaceButtons);
        this.defensiveAiBlockingMove = new DefensiveAiBlockingMove(gridSpaceButtons);
    }

    public void aiAction(int[] buttonHolder) {
        if(defensiveAiWinningMove.aiWinningMove(buttonHolder)){
            defensiveAiWinningMove.giveMove(defensiveAiWinningMove.winningMove, icon, buttonHolder);
        }
        else if(defensiveAiBlockingMove.aiBlockingMove(buttonHolder)) {
            defensiveAiBlockingMove.giveMove(defensiveAiBlockingMove.spaceToBlock, icon, buttonHolder);
        }
        else {
            randomAI.setOImagePath(oImagePath);
            randomAI.setGridSpaceButtons(gridSpaceButtons);
            randomAI.aiAction(buttonHolder);
        }
        aiMoveCount++;
    }
}


/* LOGIC ->

# to break players final move
   0,1,2
   3,4,5
   6,7,8

   0,3,6
   1,4,7
   2,5,8

   0,4,8
   2,4,6

   -> if any of the two places are occupied by X and remaining place is empty then put 'O'

# to make the winning move
   0,1,2
   3,4,5
   6,7,8

   0,3,6
   1,4,7
   2,5,8

   0,4,8
   2,4,6

   -> if any of the two places are occupied by 0 and remaining place is empty then put 'O'

*/