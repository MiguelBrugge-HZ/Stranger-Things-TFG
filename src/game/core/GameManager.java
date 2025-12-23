package game.core;

import game.stages.GameStage;
import game.stages.Stage1;
import game.stages.Stage2;
import game.utils.InputFacade;

public class GameManager {
    private static GameManager instance;

    private GameManager() {
    }

    public void startGame() {
        GameStage[] scenes = {new Stage1(), new Stage2()};
        for (GameStage scene : scenes) {
            scene.start();
        }
        checkIfPlayerWantsToReplay();
    }

    private void checkIfPlayerWantsToReplay() {
        boolean playerWantsToReplay = InputFacade.getInstance().readYesNo("Do you want to play again?");
        if (playerWantsToReplay) startGame();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
}
