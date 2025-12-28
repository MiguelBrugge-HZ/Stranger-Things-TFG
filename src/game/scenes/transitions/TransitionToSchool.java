package game.scenes.transitions;

import game.utils.InputManager;

public class TransitionToSchool {

    public static void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("You plan to go to school.");
        System.out.println("The Hallways are quiet.");
        System.out.println("Strange sounds echo. Something feels... wrong.");
        System.out.println();
        System.out.println("You grab your weapon.");
        System.out.println("A monster is waiting.");
        System.out.println();

        input.readString("Press Enter to continue...");
    }
}
