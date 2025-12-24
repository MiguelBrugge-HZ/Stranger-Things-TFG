package game.characters;

import game.scenes.Scene;

public abstract class Character implements Fighter {
    private final String name;
    private int health;

    protected Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return name;
    }
}
