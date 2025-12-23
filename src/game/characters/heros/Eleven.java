package game.characters.heros;

import game.characters.Character;

public class Eleven extends Character {
    public Eleven() { super("Eleven", 90); }

    @Override
    public void attack() {
        System.out.println(this.getName() + " attacks*");
    }
}
