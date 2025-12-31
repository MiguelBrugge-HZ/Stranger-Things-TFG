package game.scenes.dialog.intro;

import game.scenes.dialog.Dialog;
import game.utils.InputManager;

public class UpsideDownIntroDialog implements Dialog {

    @Override
    public void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("The world is cold and red.");
        System.out.println("Ash falls like snow.");
        System.out.println();
        System.out.println("This place feels alive.");
        System.out.println("And it knows you are here.");
        System.out.println();

        input.readString("Press Enter to continue...");
    }
}
