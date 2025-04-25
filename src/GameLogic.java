import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameLogic{

    final int maxAiMove = 4;
    final int maxPlayerMove = 5;

    JButton[] gridSpaceButtons;
    int[] buttonIDHolder = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    private final PlayersMove player = new PlayersMove();
    private final RandomAI randomAI = new RandomAI();
    private final DefensiveAI defensiveAI = new DefensiveAI();
    private final WinnerChecker winnerChecker = new WinnerChecker();

    boolean defaultAI = true;
    boolean playersTurn = true;
    boolean aisTurn = false;
    boolean gameOver = false;
    boolean gameDraw = false;

    public GameLogic(JButton[] gridSpaceButtons){
        this.gridSpaceButtons = gridSpaceButtons;
    }

    public void setXOIcon(String xImage, String oImage){
        player.setXImagePath(xImage);
        randomAI.setOImagePath(oImage);
        defensiveAI.setOImagePath(oImage);
    }

    public void setAI(String type){
        if(type.equals("randomAI")){
            defaultAI = true;
        }
        else if(type.equals("defensiveAI")){
            defaultAI = false;
        }
    }


    public void gameAction(ActionEvent actionEvent) {

        if (!gameOver && !gameDraw) {

            winnerChecker.setGridSpaceButtons(gridSpaceButtons, buttonIDHolder);

            if (playersTurn && player.playerMoveCount < maxPlayerMove) {
                player.buttonPressed(actionEvent);
                player.setGridSpaceButtons(gridSpaceButtons);
                player.playerAction(buttonIDHolder);
                if(!gameOver) {
                    gameOver = winnerChecker.checkForPlayerWin();
                }
                playersTurn = false;
                aisTurn = true;
            }

            if (aisTurn) {
                if(randomAI.aiMoveCount < maxAiMove && defaultAI) {
                    randomAI.setGridSpaceButtons(gridSpaceButtons);
                    randomAI.aiAction(buttonIDHolder);
                }
                else if(defensiveAI.aiMoveCount < maxAiMove && !defaultAI){
                    defensiveAI.setGridSpaceButtons(gridSpaceButtons);
                    defensiveAI.aiAction(buttonIDHolder);
                }
                if (!gameOver) {
                    gameOver = winnerChecker.checkForAiWin();
                }
                playersTurn = true;
                aisTurn = false;
            }

            if(player.playerMoveCount == maxPlayerMove && (randomAI.aiMoveCount == maxAiMove || defensiveAI.aiMoveCount == maxAiMove) && !gameOver) {
                gameDraw = winnerChecker.checkForDraw();
                playersTurn = false;
                aisTurn = false;
            }

        }

    }

}
