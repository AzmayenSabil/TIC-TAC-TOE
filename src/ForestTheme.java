import javax.swing.*;
import java.awt.*;

public class ForestTheme {

    void setClassicTheme(JFrame windowFrame, GameBoard ticTacToeBoard){
        windowFrame.setLayout(new BorderLayout());
        JLabel forestBackground=new JLabel(new ImageIcon("images/forest.jpg"));
        windowFrame.add(forestBackground);
        windowFrame.setPreferredSize(new Dimension(800, 480));
        windowFrame.getContentPane().add(forestBackground, 4);
        setBorderOfGridSpace(ticTacToeBoard);
        setButtonBackground(ticTacToeBoard);
        windowFrame.repaint();
        windowFrame.pack();
        windowFrame.setVisible(true);
    }

    void setBorderOfGridSpace(GameBoard ticTacToeBoard){
        for(int box = 0; box < 9; box++){
            ticTacToeBoard.gridSpaceButtons[box].setBorder(BorderFactory.createLineBorder(new Color(34,139,34)));
        }
    }

    void setButtonBackground(GameBoard ticTacToeBoard){
        for(int box = 0; box < 9; box++){
            ticTacToeBoard.gridSpaceButtons[box].setBackground(Color.GREEN);
        }
    }
}
