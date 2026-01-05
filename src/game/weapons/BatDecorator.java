package game.weapons;

import game.characters.Character;
import game.characters.CharacterDecorator;
import game.combat.Move;

public class BatDecorator extends CharacterDecorator {

    public BatDecorator(Character wrapped) {
        super(wrapped);
        moves.add(new Move("🏏 Bat Slash", 14, 30, 0.85));
    }

    @Override
    public String toString() {
        return "Bat";
    }

    @Override
    public String getName() {
        return wrapped.getName() + " with Bat";
    }
}
