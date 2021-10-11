import javax.swing.*;
import java.awt.*;


public class ClassicTheme{

    void setClassicTheme(JFrame windowFrame, GameBoard ticTacToeBoard){
        windowFrame.setLayout(new BorderLayout());
        JLabel classicBackground=new JLabel(new ImageIcon("images/classic.jpg"));
        windowFrame.add(classicBackground);
        windowFrame.setPreferredSize(new Dimension(800, 480));
        windowFrame.getContentPane().add(classicBackground, 4);
        setBorderOfGridSpace(ticTacToeBoard);
        setButtonBackground(ticTacToeBoard);
        windowFrame.repaint();
        windowFrame.pack();
        windowFrame.setVisible(true);
    }

    void setBorderOfGridSpace(GameBoard ticTacToeBoard){
        for(int box = 0; box < 9; box++){
            ticTacToeBoard.gridSpaceButtons[box].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    void setButtonBackground(GameBoard ticTacToeBoard){
        for(int box = 0; box < 9; box++){
            ticTacToeBoard.gridSpaceButtons[box].setBackground(Color.WHITE);
        }
    }

}
