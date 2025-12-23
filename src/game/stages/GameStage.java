package game.stages;

import game.characters.heros.Eleven;
import game.scenes.Scene;

public abstract class GameStage {
    abstract Scene createScene();
    public void start() {
        Scene scene = this.createScene();
        scene.play(new Eleven());
    }
}
