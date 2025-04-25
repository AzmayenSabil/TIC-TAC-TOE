import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class GameRestart {

    void startNewGame() throws Exception {
        dispose();
        new TicTacToeGameInitiator();
    }

}
