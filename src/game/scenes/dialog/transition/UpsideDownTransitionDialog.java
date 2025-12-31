package game.scenes.dialog.transition;

import game.scenes.dialog.Dialog;
import game.utils.InputManager;

public class UpsideDownTransitionDialog implements Dialog {

    @Override
    public void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("The creature falls.");
        System.out.println("The room goes silent.");
        System.out.println();
        System.out.println("Then— the walls begin to bleed.");
        System.out.println("A glowing tear opens in reality.");
        System.out.println();
        System.out.println("You are pulled inside.");
        System.out.println();

        input.readString("Press Enter to continue...");
    }
}
