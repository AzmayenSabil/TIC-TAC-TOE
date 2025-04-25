import javax.swing.*;
import java.awt.*;


public class GameBoard{

    JPanel boardPanel = new JPanel();
    JButton[] gridSpaceButtons = new JButton[9];

    private final JFrame windowFrame;
    private final GameLogic gameLogic = new GameLogic(gridSpaceButtons);

    public GameBoard(JFrame windowFrame){
        this.windowFrame = windowFrame;
    }

    public void setAIForGameLogic(String type){
        gameLogic.setAI(type);
    }

    public void setImageForXO(String x, String o){
        gameLogic.setXOIcon(x, o);
    }

    public void createThreeByThreeGrid(){
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBounds(0,0,450,450);

        for(int box = 0; box < 9; box ++) {
            gridSpaceButtons[box] = new JButton();
            boardPanel.add(gridSpaceButtons[box]);

            gridSpaceButtons[box].setBackground(Color.DARK_GRAY);
            gridSpaceButtons[box].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            gridSpaceButtons[box].setFont(new Font("MV Boli",Font.BOLD,120));
            gridSpaceButtons[box].setFocusable(false);
            gridSpaceButtons[box].addActionListener(gameLogic::gameAction);
        }

        this.windowFrame.add(boardPanel);

    }

}
