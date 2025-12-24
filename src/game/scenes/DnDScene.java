package game.scenes;

import game.characters.Character;

public class DnDScene extends Scene{
    @Override
    public void play() {
        System.out.println("Stage 1 -- DnD");
        startScene();
        endScene();
    }

    @Override
    public void startScene() {
        System.out.println("DnDScene play");
    }

    @Override
    public void endScene() {
        System.out.println("DnDScene end");
    }
}
