package game.scenes;
import game.characters.Character;

public abstract class Scene {
    protected Character player;
    protected abstract void startScene();
    protected abstract void endScene();

    public void setPlayer(Character player) {
        this.player = player;
    }

    public Character play() {
        startScene();
        endScene();
        return player;
    }
}
