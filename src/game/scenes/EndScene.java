package game.scenes;

import game.characters.Character;
import game.scenes.result.GameOverScene;
import game.scenes.result.VictoryScene;

public class EndScene extends Scene {

    private final boolean victory;

    public EndScene(boolean victory) {
        this.victory = victory;
    }

    @Override
    protected void startScene() {
        if (victory) {
            VictoryScene.play(player);
        } else {
            GameOverScene.play(player);
        }
    }

    @Override
    protected Scene endScene() {
        return null;
    }
}
