package game.weapons;

import game.characters.Character;
import game.characters.CharacterDecorator;
import game.combat.Move;

public class HammerDecorator extends CharacterDecorator {

    public HammerDecorator(Character wrapped) {
        super(wrapped);
        moves.add(new Move("🔨 Crushing Blow", 12, 25, 0.6));
    }

    @Override
    public String toString() {
        return "Hammer";
    }

    @Override
    public String getName() {
        return wrapped.getName() + " with Hammer";
    }
}
