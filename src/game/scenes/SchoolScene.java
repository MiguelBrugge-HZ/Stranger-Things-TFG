package game.scenes;

import game.characters.Character;

public class SchoolScene extends Scene{
    @Override
    public void play() {
        startScene();
        endScene();
    }

    @Override
    public void startScene() {
        System.out.println("SchoolScene play");
    }

    @Override
    public void endScene() {
        System.out.println("SchoolScene end");
    }
}
