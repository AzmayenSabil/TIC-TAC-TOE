import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayersMove{

    private ActionEvent actionEvent;
    JButton[] gridSpaceButtons;
    int playerMoveCount = 0;
    String xImagePath;
    Icon icon;

    public void setXImagePath(String xImagePath){
        this.xImagePath = xImagePath;
        icon = new ImageIcon(xImagePath);
    }

    void setGridSpaceButtons(JButton[] gridSpaceButtons){
        this.gridSpaceButtons = gridSpaceButtons;
    }

    public void playerAction(int[] buttonHolder){

        for (int box = 0; box < 9; box++) {
            if (actionEvent.getSource() == gridSpaceButtons[box] && buttonHolder[box] == -1) {
                gridSpaceButtons[box].setForeground(new Color(0, 0, 255));
                buttonHolder[box] = 1;
                gridSpaceButtons[box].setIcon(icon);
                playerMoveCount++;
            }
        }

    }

    public void buttonPressed(ActionEvent actionEvent){
        this.actionEvent = actionEvent;
    }
}
