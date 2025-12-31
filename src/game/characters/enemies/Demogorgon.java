package game.characters.enemies;

import game.characters.Enemy;
import game.combat.Move;
import java.util.List;

public class Demogorgon extends Enemy {
    public Demogorgon() {
        super("Demogorgon", 120, List.of(
                new Move("🦴Claw Swipe", 10, 15, 0.8),
                new Move("🖤Tentacle Grab", 8, 18, 0.6),
                new Move("😱Screech", 5, 25, 0.5)
        ));
    }
}
