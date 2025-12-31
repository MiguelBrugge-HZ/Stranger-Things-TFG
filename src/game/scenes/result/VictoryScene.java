package game.scenes.result;
import game.characters.Character;

public class VictoryScene {

    public static void play(Character player) {
        System.out.println("\n🏆 FINAL VICTORY 🏆");
        System.out.println(player.getName() + " has defeated Vecna!");
        System.out.println("Hawkins is safe again.");
        System.out.println("Thanks for playing Stranger Things TFG.");
    }
}
