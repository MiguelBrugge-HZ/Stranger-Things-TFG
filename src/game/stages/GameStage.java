package game.stages;

import game.characters.CharacterDecorator;
import game.scenes.Scene;
import game.characters.Character;

public abstract class GameStage {
    abstract Scene createScene();
    public Character start(Character player) {
        Scene scene = this.createScene();
        scene.setPlayer(player);
        System.out.println();
        return scene.play();
    }

    public void playTransition() {
    }
}
