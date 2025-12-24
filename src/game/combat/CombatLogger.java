package game.combat;

import game.characters.Character;

public class CombatLogger {

    public void logAttack(Character attacker, Character defender, int damage) {
        System.out.println(attacker.getName() + " deals " + damage +
                " 💥 damage ➡️ " + defender.getName());
        System.out.println(defender.getName() + " ❤️: " + defender.getHealth());
    }

    public void logWinner(Character winner) {
        System.out.println(winner.getName() + " wins the fight!🎖️");
    }
}
