package game.combat;

import game.characters.Character;

public class CombatFacade {
    private final HealthSystem healthSystem = new HealthSystem();
    private final CombatLogger logger = new CombatLogger();

    public void fight(Character player, Character enemy) {
        System.out.println("Combat starts: " + player.getName() + " ⚔️ " + enemy.getName());

        while (healthSystem.isAlive(player) && healthSystem.isAlive(enemy)) {
            executeTurn(player, enemy, true);
            if (!healthSystem.isAlive(enemy)) break;

            executeTurn(enemy, player, false);
        }

        Character winner = healthSystem.isAlive(player) ? player : enemy;
        logger.logWinner(winner);
    }

    private void executeTurn(Character attacker, Character defender, boolean playerTurn) {
//        Move move = playerTurn ? attacker.chooseMove() : attacker.chooseRandomMove();
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
