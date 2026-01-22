package game.core;

import game.characters.heros.Eleven;
import game.characters.heros.Steve;
import game.combat.CombatFacade;
import game.scenes.DnDScene;
import game.scenes.Scene;
import game.utils.InputManager;
import game.characters.Character;

import java.util.List;

public class GameManager {
    private static GameManager instance;

    private GameManager() {}

    public void startGame() {
        Character player = chooseCharacter();

        CombatFacade combatFacade = new CombatFacade();

        Scene currentScene = new DnDScene(combatFacade);
        currentScene.setPlayer(player);

        while (currentScene != null) {
            currentScene = currentScene.play();
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
