package game.scenes.dialog.intro;

import game.scenes.dialog.Dialog;
import game.utils.InputManager;

public class SchoolIntroDialog implements Dialog {

    @Override
    public void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("The school stands dark and empty.");
        System.out.println("Lockers hum softly under flickering lights.");
        System.out.println();
        System.out.println("Something moves in the shadows.");
        System.out.println("You are not alone.");
        System.out.println();

        input.readString("Press Enter to continue...");
    }
}
