package game.characters.enemies;

import game.characters.Enemy;
import game.combat.Move;

import java.util.List;

public class Vecna extends Enemy {
    public Vecna() {
        super("Vecna", 160, List.of(
                new Move("🖐️ Mind Crush", 12, 20, 0.75),
                new Move("🕷️ Psychic Grip", 8, 25, 0.6),
                new Move("💀 Reality Break", 20, 45, 0.35)
        ));
    }
}
