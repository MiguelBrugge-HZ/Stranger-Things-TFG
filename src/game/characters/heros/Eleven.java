package game.characters.heros;
import game.characters.Hero;
import game.combat.Move;
import java.util.List;

public class Eleven extends Hero {
    public Eleven() {
        super("Eleven", 90, List.of(
                new Move("🤜Punch", 12, 20, 0.95),
                new Move("🌪️Telekinetic Throw", 16, 35, 0.7),
                new Move("🤯Mind Blast", 25, 45, 0.4)
        ));
    }
}
