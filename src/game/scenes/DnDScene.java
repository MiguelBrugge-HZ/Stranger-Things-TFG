package game.scenes;

import game.characters.Character;
import game.scenes.transitions.TransitionToSchool;
import game.utils.InputManager;
import game.weapons.BatDecorator;
import game.weapons.HammerDecorator;

import java.util.List;

public class DnDScene extends Scene{
    @Override
    public Character play() {
        System.out.println("Stage 1 -- DnD");
        startScene();
        TransitionToSchool.play();
        endScene();
        return player;
    }

    @Override
    public void startScene() {
        System.out.println("DnDScene play");
        player = chooseWeapon(player);
        System.out.println(player.getClass().getSimpleName());
    }

    private Character chooseWeapon(Character player) {
        List<Character> weapons = List.of(
                new BatDecorator(player),
                new HammerDecorator(player)
        );

        InputManager input = InputManager.getInstance();
        return input.chooseOption("Choose your weapon:", weapons);
    }

    @Override
    public void endScene() {
        System.out.println("DnDScene end");
    }
}
