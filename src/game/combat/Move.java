package game.combat;

import java.util.Random;

public class Move {
    private final String name;
    private final int minDamage;
    private final int maxDamage;
    private final double hitChance; // 0.0 to 1.0

    private static final Random RANDOM = new Random();

    public Move(String name, int minDamage, int maxDamage, double hitChance) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hitChance = hitChance;
    }

    public String getName() {
        return name;
    }

    public int execute() {
        if (RANDOM.nextDouble() <= hitChance) {
            return RANDOM.nextInt(maxDamage - minDamage + 1) + minDamage;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name + " (Damage: " + minDamage + "-" + maxDamage + ", Hit chance: " + (int)(hitChance*100) + "%)";
    }
}
