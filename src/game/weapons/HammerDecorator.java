package game.weapons;

import game.characters.Character;
import game.characters.CharacterDecorator;
import game.combat.Move;

public class HammerDecorator extends CharacterDecorator {

    public HammerDecorator(Character wrapped) {
        super(wrapped);
        name = "Hammer";
        moves.add(new Move("🔨 Crushing Blow", 12, 25, 0.6));
    }
}
