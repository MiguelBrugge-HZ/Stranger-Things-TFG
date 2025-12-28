package game.core;

import game.characters.heros.Eleven;
import game.characters.heros.Steve;
import game.scenes.Result.GameOverScene;
import game.scenes.Result.VictoryScene;
import game.stages.*;
import game.utils.InputManager;
import game.characters.Character;

import java.util.List;

public class GameManager {
    private static GameManager instance;

    private GameManager() {}

    public void startGame() {
        GameStage[] scenes = {
                new Stage1(),
                new Stage2(),
                new Stage3(),
                new Stage4()
        };

        Character player = chooseCharacter();
        boolean playerDied = false;

        for (GameStage scene : scenes) {
            player = scene.start(player);

            if (!player.isAlive()) {
                showGameOver(player);
                playerDied = true;
                break;
            }
            scene.playTransition();
        }

        if (!playerDied) {
            showVictory(player);
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

    private void showVictory(Character player) {
        VictoryScene.play(player);
    }

    private void showGameOver(Character player) {
        GameOverScene.play(player);
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
