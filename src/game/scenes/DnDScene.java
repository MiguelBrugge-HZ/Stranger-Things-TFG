package game.scenes;

import game.characters.Character;

public class DnDScene implements Scene{
    @Override
    public void play(Character character) {
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
