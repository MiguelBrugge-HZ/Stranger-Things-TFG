package game.core;

import game.characters.enemies.Demogorgon;
import game.characters.heros.Eleven;
import game.characters.heros.Steve;
import game.stages.GameStage;
import game.stages.Stage1;
import game.stages.Stage2;
import game.stages.Stage3;
import game.utils.InputManager;
import game.characters.Character;

import java.util.List;

public class GameManager {
    private static GameManager instance;

    private GameManager() {}

    public void startGame() {
        GameStage[] scenes = { new Stage1(), new Stage2(), new Stage3()};
        Character player = chooseCharacter();
        for (GameStage scene : scenes) {
            player = scene.start(player);
        }
        replayIfWanted();
    }

    private Character chooseCharacter() {
        List<Character> characters = List.of(
                new Eleven(),
                new Steve()
        );

        InputManager input = InputManager.getInstance();
        return input.chooseOption("Choose your character:", characters);
    }

    private void replayIfWanted() {
        boolean playerWantsToReplay = InputManager.getInstance()
                .readYesNo("Do you want to play again?");
        if (playerWantsToReplay) startGame();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
}
