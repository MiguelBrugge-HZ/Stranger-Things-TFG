package game.characters.enemies;

import game.characters.Character;

public class Demogorgon extends Character {
    public Demogorgon() {
        super("Demogorgon", 90);
    }

    @Override
    public void attack() {
        System.out.println(this.getName() + " attacks*");
    }
}
