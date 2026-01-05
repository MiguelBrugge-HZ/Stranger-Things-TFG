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
        List<String> weapons = List.of("Bat", "Hammer");

        InputManager input = InputManager.getInstance();
        String choice = input.chooseOption("Choose your weapon:", weapons);

        return switch (choice) {
            case "Bat" -> new BatDecorator(player);
            case "Hammer" -> new HammerDecorator(player);
            default -> player;
        };
    }

    @Override
    public void endScene() {
        new SchoolTransitionDialog().play();
        player = chooseWeapon(player);
    }
}
