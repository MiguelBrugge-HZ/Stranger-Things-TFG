package game.scenes.dialog.intro;

import game.scenes.dialog.Dialog;
import game.utils.InputManager;

public class DnDIntroDialog implements Dialog {

    @Override
    public void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("Dice roll across the table.");
        System.out.println("Your campaign reaches a critical moment.");
        System.out.println();
        System.out.println("\"The Demogorgon is near,\" the Dungeon Master says.");
        System.out.println("Suddenly... he freezes.");
        System.out.println();
        System.out.println("\"No... this feels real.\"");
        System.out.println();

        input.readString("Press Enter to continue...");
    }
}
