package game.characters.heros;

import game.characters.Character;
import game.combat.Move;

import java.util.List;

public class Eleven extends Character {
    public Eleven() {
        super("Eleven", 90, List.of(
                new Move("🤜Punch", 8, 12, 0.9),
                new Move("🌪️Telekinetic Throw", 10, 20, 0.7),
                new Move("🤯Mind Blast", 5, 30, 0.4)
        ));
    }
}
