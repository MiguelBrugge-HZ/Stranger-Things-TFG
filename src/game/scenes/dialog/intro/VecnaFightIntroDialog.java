package game.scenes.dialog.intro;

import game.scenes.dialog.Dialog;
import game.utils.InputManager;

public class VecnaFightIntroDialog implements Dialog {

    @Override
    public void play() {
        InputManager input = InputManager.getInstance();

        System.out.println();
        System.out.println("Pain floods your thoughts.");
        System.out.println("Vecna towers before you.");
        System.out.println();
        System.out.println("\"Every world breaks eventually.\"");
        System.out.println();
        System.out.println("You tighten your grip on your weapon.");
        System.out.println("This ends now.");
        System.out.println();

        input.readString("Press Enter to continue...");
    }
}
