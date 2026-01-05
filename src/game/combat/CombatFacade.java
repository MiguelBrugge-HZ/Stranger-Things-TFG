package game.combat;

import game.characters.Character;

public class CombatFacade {
    private final HealthSystem healthSystem = new HealthSystem();
    private final CombatLogger logger = new CombatLogger();

    public void fight(Character player, Character enemy) {
        System.out.println("Combat starts: " + player.getName() + " ⚔️ " + enemy.getName());

        while (player.isAlive() && enemy.isAlive()) {
            executeTurn(player, enemy);
            if (!enemy.isAlive()) break;

            executeTurn(enemy, player);
        }

        Character winner = player.isAlive() ? player : enemy;
        logger.logWinner(winner);
    }

    private void executeTurn(Character attacker, Character defender) {
        Move move = attacker.chooseMove();
        System.out.println(attacker.getName() + " uses " + move.getName());

        int damage = move.execute();
        if (damage > 0) {
            healthSystem.applyDamage(defender, damage);
        } else {
            System.out.println(attacker.getName() + "'s attack missed!💨");
        }

        logger.logAttack(attacker, defender, damage);
        System.out.println();
    }
}
