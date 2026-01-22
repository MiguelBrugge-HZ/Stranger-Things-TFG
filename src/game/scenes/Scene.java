package game.scenes;
import game.characters.Character;

public abstract class Scene {
    protected Character player;

    protected abstract void startScene();
    protected abstract Scene endScene();

    public void setPlayer(Character player) {
        this.player = player;
    }

    public final Scene play() {
        startScene();
        fightScene();
        return endScene();
    }

    protected void fightScene() {
    }
}
