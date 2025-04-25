import javax.swing.*;
import java.awt.*;


public class HighContrastTheme {

    void setClassicTheme(JFrame windowFrame, GameBoard ticTacToeBoard){
        windowFrame.setLayout(new BorderLayout());
        JLabel highContrastBackground=new JLabel(new ImageIcon("images/highContrast.jpg"));
        windowFrame.add(highContrastBackground);
        windowFrame.setPreferredSize(new Dimension(800, 480));
        windowFrame.getContentPane().add(highContrastBackground, 4);
        setBorderOfGridSpace(ticTacToeBoard);
        setButtonBackground(ticTacToeBoard);
        windowFrame.repaint();
        windowFrame.pack();
        windowFrame.setVisible(true);
    }

    void setBorderOfGridSpace(GameBoard ticTacToeBoard){
        for(int box = 0; box < 9; box++){
            ticTacToeBoard.gridSpaceButtons[box].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }
    }

    void setButtonBackground(GameBoard ticTacToeBoard){
        for(int box = 0; box < 9; box++){
            ticTacToeBoard.gridSpaceButtons[box].setBackground(Color.DARK_GRAY);
        }
    }
}
