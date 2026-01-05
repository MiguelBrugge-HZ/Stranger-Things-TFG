package game.weapons;

import game.characters.CharacterDecorator;
import game.characters.Character;
import game.combat.Move;

public class HammerDecorator extends CharacterDecorator {

    public HammerDecorator(Character wrapped) {
        super(wrapped);
        wrapped.getMoves().add(new Move("🔨 Crushing Blow", 22, 40, 0.6));
    }

    @Override
    public String getName() {
        return wrapped.getName() + " with Hammer";
    }
}
