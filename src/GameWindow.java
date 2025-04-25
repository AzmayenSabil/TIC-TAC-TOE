import javax.swing.*;
import java.awt.*;

public class GameWindow {

    private final JFrame windowFrame = new JFrame();
    private final ImageIcon titleBarLogo = new ImageIcon("images/gameLogo.png");

    private final GameBoard ticTacToeBoard = new GameBoard(windowFrame);

    private final GameOptionGenerator themeOptionGenerator = new ThemeOption(windowFrame, ticTacToeBoard);
    private final GameOptionGenerator playOptionGenerator = new PlayOption(windowFrame, ticTacToeBoard);

    public GameWindow(int height, int width){

        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(height,width);
        windowFrame.getContentPane().setBackground(new Color(0x123456));
        windowFrame.setLayout(null);
        windowFrame.setTitle("Tic Tac Toe" );
        windowFrame.setIconImage(titleBarLogo.getImage());

        ticTacToeBoard.createThreeByThreeGrid();
        themeOptionGenerator.generateOptions();
        playOptionGenerator.generateOptions();

        windowFrame.setResizable(false);
        windowFrame.setVisible(true);

    }

}
