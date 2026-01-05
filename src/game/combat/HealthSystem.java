package game.combat;

import game.characters.Character;

public class HealthSystem {

    public void applyDamage(Character target, int damage) {
        int newHealth = target.getHealth() - damage;
        target.setHealth(Math.max(newHealth, 0));
    }
}
