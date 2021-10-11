import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ThemeOption implements GameOptionGenerator {

    JFrame windowFrame;
    GameBoard ticTacToeBoard;

    private final JPanel titlePanel = new JPanel();
    private final JLabel titleText = new JLabel();

    private final JPanel optionHoldingPanel = new JPanel();
    private final JButton[] optionButtons = new JButton[3];

    private final ClassicTheme classicTheme = new ClassicTheme();
    private final ForestTheme forestTheme = new ForestTheme();
    private final HighContrastTheme highContrastTheme = new HighContrastTheme();

    boolean themeChanged = false;

    public ThemeOption(JFrame windowFrame, GameBoard ticTacToeBoard){
        this.windowFrame = windowFrame;
        this.ticTacToeBoard = ticTacToeBoard;
        initializeOptionTitleText();
        initializeOptionsText();
    }

    public void initializeOptionTitleText(){
        titleText.setBackground(new Color(25,25,25));
        titleText.setForeground(new Color(25,255,0));
        titleText.setFont(new Font("Ink Free",Font.BOLD,20));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        titleText.setText("THEME");
        titleText.setOpaque(true);
    }

    public void initializeOptionsText(){

        for(int button = 0; button < 3; button++){
            optionButtons[button] = new JButton();
            optionButtons[button].setBackground(new Color(25,25,25));
            optionButtons[button].setForeground(new Color(125,125,125));
            optionButtons[button].setFont(new Font("Ink Free",Font.BOLD,15));
            optionButtons[button].setHorizontalAlignment(JLabel.CENTER);
            optionButtons[button].addActionListener(this::actionHandlerForTheme);
            optionButtons[button].setOpaque(true);
        }

        optionButtons[0].setText("Classic");
        optionButtons[1].setText("Forest");
        optionButtons[2].setText("High Contrast");

    }

    public void generateOptions(){

        this.titlePanel.setLayout(new BorderLayout());
        this.titlePanel.setBounds(580,20,100,30);
        this.titlePanel.add(titleText);

        this.optionHoldingPanel.setLayout(new GridLayout(3,1));
        this.optionHoldingPanel.setBounds(530,60,200,90);
        for(int option = 0; option < 3; option++){
            this.optionHoldingPanel.add(optionButtons[option]);
        }

        this.windowFrame.getContentPane().add(titlePanel);
        this.windowFrame.getContentPane().add(optionHoldingPanel);

    }

    public void actionHandlerForTheme(ActionEvent actionEvent) {
        if (actionEvent.getSource() == optionButtons[0] && !themeChanged) {
            classicTheme.setClassicTheme(this.windowFrame, this.ticTacToeBoard);
            ticTacToeBoard.setImageForXO("images/x.png", "images/o.png");
        }
        else if (actionEvent.getSource() == optionButtons[1] && !themeChanged) {
            forestTheme.setClassicTheme(this.windowFrame, this.ticTacToeBoard);
            ticTacToeBoard.setImageForXO("images/flower.png", "images/fruit.png");
        }
        else if (actionEvent.getSource() == optionButtons[2] && !themeChanged) {
            highContrastTheme.setClassicTheme(this.windowFrame, this.ticTacToeBoard);
            ticTacToeBoard.setImageForXO("images/black.jpg", "images/white.jpg");
        }
        themeChanged = true;
    }
}
