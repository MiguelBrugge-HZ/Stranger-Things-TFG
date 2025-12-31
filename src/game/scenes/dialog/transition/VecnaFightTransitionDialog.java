package game.scenes.dialog.transition;

import game.scenes.dialog.Dialog;
import game.utils.InputManager;

public class VecnaFightTransitionDialog implements Dialog {

    @Override
    public void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("The bats scatter into the dark.");
        System.out.println("Everything becomes still.");
        System.out.println();
        System.out.println("A presence presses into your mind.");
        System.out.println();
        System.out.println("\"You should have stayed away.\"");
        System.out.println();
        System.out.println("Vecna steps forward.");
        System.out.println();

        input.readString("Press Enter to face Vecna...");
    }
}
