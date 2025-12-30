package game.scenes.transitions;

import game.utils.InputManager;

public class TransitionToUpsideDown {

    public static void play() {
        InputManager input = InputManager.getInstance();

        System.out.println("The school goes silent...");
        System.out.println("A cold wind blows through the hallway.");
        System.out.println("Reality starts to crack.");
        System.out.println("You are pulled into the Upside Down...");
        System.out.println();
        input.readString("Press Enter to continue...");
    }
}
