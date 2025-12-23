package game.scenes;
import game.characters.Character;

public interface Scene {
    void play(Character character);
    void startScene();
    void endScene();
}
