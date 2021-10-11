import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayOption implements GameOptionGenerator{

    private final JFrame windowFrame;
    private final GameBoard gameBoard;

    private final JPanel optionHoldingPanel = new JPanel();
    private final JButton[] optionButtons = new JButton[2];

    public PlayOption(JFrame windowFrame, GameBoard gameBoard){
        this.windowFrame = windowFrame;
        this.gameBoard = gameBoard;
        initializeOptionTitleText();
        initializeOptionsText();
    }

    @Override
    public void initializeOptionTitleText() { }

    @Override
    public void initializeOptionsText(){

        for(int button = 0; button < 2; button++){
            optionButtons[button] = new JButton();
            optionButtons[button].setBackground(new Color(25,25,25));
            optionButtons[button].setForeground(Color.ORANGE);
            optionButtons[button].setFont(new Font("Ink Free",Font.BOLD,15));
            optionButtons[button].setHorizontalAlignment(JLabel.CENTER);
            optionButtons[button].addActionListener(this::actionHandlerForPlay);
            optionButtons[button].setOpaque(true);
        }

        optionButtons[0].setText("Start With Random AI");
        optionButtons[1].setText("Start With Defensive AI");

    }

    @Override
    public void generateOptions(){

        this.optionHoldingPanel.setLayout(new GridLayout(2,1));
        this.optionHoldingPanel.setBounds(505,300,250,60);

        for(int option = 0; option < 2; option++){
            this.optionHoldingPanel.add(optionButtons[option]);
        }
        this.windowFrame.getContentPane().add(optionHoldingPanel);
    }


    public void actionHandlerForPlay(ActionEvent actionEvent){
        for (int option = 0; option < 2; option++) {
            if (actionEvent.getSource() == optionButtons[option] && optionButtons[option].getText().equals("Start With Random AI")) {
                gameBoard.setAIForGameLogic("randomAI");
            }
            else if (actionEvent.getSource() == optionButtons[option] && optionButtons[option].getText().equals("Start With Defensive AI")) {
                gameBoard.setAIForGameLogic("defensiveAI");
            }
        }
    }

}

