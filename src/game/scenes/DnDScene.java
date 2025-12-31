package game.scenes;

import game.characters.Character;
import game.scenes.dialog.intro.DnDIntroDialog;
import game.scenes.dialog.transition.SchoolTransitionDialog;
import game.utils.InputManager;
import game.weapons.BatDecorator;
import game.weapons.HammerDecorator;

import java.util.List;

public class DnDScene extends Scene{
    @Override
    public void startScene() {
        new DnDIntroDialog().play();
    }

    private Character chooseWeapon(Character player) {
        List<Character> weaponChoices = List.of(
                new BatDecorator(player),
                new HammerDecorator(player)
        );

        InputManager input = InputManager.getInstance();
        return input.chooseOption("Choose your weapon:", weaponChoices);
    }

    @Override
    public void endScene() {
        new SchoolTransitionDialog().play();
        player = chooseWeapon(player);
    }
}
