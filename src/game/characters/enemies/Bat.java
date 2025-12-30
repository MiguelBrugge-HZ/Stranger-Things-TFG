package game.characters.enemies;

import game.characters.Enemy;
import game.combat.Move;

import java.util.List;

public class Bat extends Enemy {
    public Bat() {
        super("Bat", 90, List.of(
                new Move("🦇 Bite", 6, 10, 0.9),
                new Move("🌪️ Wing Flap", 4, 8, 0.95),
                new Move("🔊 Sonic Screech", 3, 14, 0.7)
        ));
    }

    @Override
    public void attack() {
        System.out.println(this.getName() + " attacks*");
    }
}
