package game.scenes;
import game.characters.Character;

public abstract class Scene {
    protected Character player;
    public abstract Character play();
    protected abstract void startScene();
    protected abstract void endScene();

    public void setPlayer(Character player) {
        this.player = player;
    }
}
