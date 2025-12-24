package game.core;

import game.characters.enemies.Demogorgon;
import game.characters.heros.Eleven;
import game.stages.GameStage;
import game.stages.Stage1;
import game.stages.Stage2;
import game.utils.InputFacade;
import game.characters.Character;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager instance;

    private GameManager() {}

    public void startGame() {
        GameStage[] scenes = { new Stage1(), new Stage2() };
        Character player = chooseCharacter();
        for (GameStage scene : scenes) {
            scene.start(player);
        }
        replayIfWanted();
    }

    private void replayIfWanted() {
        boolean playerWantsToReplay = InputFacade.getInstance()
                .readYesNo("Do you want to play again?");
        if (playerWantsToReplay) startGame();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Character chooseCharacter() {
        List<Character> characters = List.of(
                new Eleven(),
                new Demogorgon()
        );

        InputFacade input = InputFacade.getInstance();
        return input.chooseOption("Choose your character:", characters);
    }
}
