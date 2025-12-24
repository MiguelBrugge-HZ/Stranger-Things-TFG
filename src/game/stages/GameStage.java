package game.stages;

import game.scenes.Scene;
import game.characters.Character;

public abstract class GameStage {
    abstract Scene createScene();
    public void start(Character player) {
        Scene scene = this.createScene();
        scene.setPlayer(player);
        scene.play();
    }
}
