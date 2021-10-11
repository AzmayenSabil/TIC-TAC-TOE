import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class RandomAI{

    JButton[] gridSpaceButtons;
    Random random = new Random();
    int aiMoveCount = 0;
    String oImagePath;
    Icon icon;

    Vector<Integer> emptyGridBoxes = new Vector<Integer>();

    public void setOImagePath(String oImagePath){
        this.oImagePath = oImagePath;
        icon = new ImageIcon(oImagePath);
    }

    void setGridSpaceButtons(JButton[] gridSpaceButtons){
        this.gridSpaceButtons = gridSpaceButtons;
    }

    public void aiAction(int[] buttonHolder){

        emptyGridBoxes.clear();
        for (int box = 0; box < 9; box++) {
            if (buttonHolder[box] == -1) {
                emptyGridBoxes.add(box);
            }
        }
        int randIndex = randomIntGenerator(emptyGridBoxes.size());
        int index = emptyGridBoxes.get(randIndex);

        gridSpaceButtons[index].setForeground(new Color(255, 0, 0));
        buttonHolder[index] = 0;
        gridSpaceButtons[index].setIcon(icon);
        aiMoveCount++;

    }

    private int randomIntGenerator(int limit){
        return random.nextInt(limit);
    }
}
