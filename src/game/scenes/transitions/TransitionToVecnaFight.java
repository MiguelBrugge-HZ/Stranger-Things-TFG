package game.scenes.transitions;

import game.utils.InputManager;

public class TransitionToVecnaFight {

    public static void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("The Upside Down grows silent.");
        System.out.println("The air becomes heavy.");
        System.out.println("A voice echoes in your mind...");
        System.out.println();
        System.out.println("\"You cannot escape.\"");
        System.out.println();
        System.out.println("Vecna reveals himself.");
        System.out.println();

        input.readString("Press Enter to face Vecna...");
    }
}
