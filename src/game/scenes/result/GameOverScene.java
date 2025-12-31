package game.scenes.result;

import game.characters.Character;

public class GameOverScene {

    public static void play(Character player) {
        System.out.println("\n💀 GAME OVER 💀");
        System.out.println(player.getName() + " has fallen...");
        System.out.println("The Upside Down consumes Hawkins.");
    }
}