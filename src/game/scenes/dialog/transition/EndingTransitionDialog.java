package game.scenes.dialog.transition;

import game.scenes.dialog.Dialog;
import game.utils.InputManager;

public class EndingTransitionDialog implements Dialog {

    @Override
    public void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("Vecna lets out a final scream.");
        System.out.println("The Upside Down begins to collapse.");
        System.out.println();
        System.out.println("Light breaks through the darkness.");
        System.out.println("The world starts to heal.");
        System.out.println();
        System.out.println("You wake up back in Hawkins.");
        System.out.println("The danger is gone.");
        System.out.println();
        System.out.println("For now.");
        System.out.println();
        System.out.println("You won.");
        System.out.println();

        input.readString("Press Enter to end the game...");
    }
}
