package game.stages;

import game.scenes.DnDScene;
import game.scenes.Scene;

public class Stage1 extends GameStage {
    @Override
    Scene createScene() { return new DnDScene(); }
}
