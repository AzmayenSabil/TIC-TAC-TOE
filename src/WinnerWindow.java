import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinnerWindow {

    GameRestart gameRestart = new GameRestart();

    final int height = 300;
    final int width = 200;

    private final JFrame winnerFrame = new JFrame();
    private final JLabel winnerLabel = new JLabel();

    private final JPanel buttonHolder = new JPanel();
    private final JButton restartButton = new JButton("RESTART");


    public WinnerWindow(String text){

        winnerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        winnerFrame.setSize(height,width);
        winnerFrame.getContentPane().setBackground(new Color(0x9999));
        winnerFrame.setTitle("WHO WON ??");
        winnerFrame.setLayout(null);

        winnerLabel.setBounds(120,40,80,20);
        winnerLabel.setText(text);

        restartButton.addActionListener(actionEvent -> {
            try {
                gameRestart.startNewGame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        restartButton.setBackground(Color.WHITE);
        restartButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        buttonHolder.setBounds(110,80,80,30);
        buttonHolder.add(restartButton);

        winnerFrame.add(winnerLabel);
        winnerFrame.add(buttonHolder);

        winnerFrame.setResizable(false);
        winnerFrame.setVisible(true);

    }


}
