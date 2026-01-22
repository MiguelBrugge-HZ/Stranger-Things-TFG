package game.scenes;

import game.characters.Character;
import game.scenes.dialog.intro.DnDIntroDialog;
import game.scenes.dialog.transition.SchoolTransitionDialog;
import game.utils.InputManager;
import game.weapons.BatDecorator;
import game.weapons.HammerDecorator;
import game.combat.CombatFacade;

import java.util.List;

public class DnDScene extends Scene {

    private final CombatFacade combatFacade;

    public DnDScene(CombatFacade combatFacade) {
        this.combatFacade = combatFacade;
    }

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
    protected Scene endScene() {
        player = chooseWeapon(player);

        new SchoolTransitionDialog().play();

        Scene next = new SchoolScene(combatFacade);
        next.setPlayer(player);
        return next;
    }
}
