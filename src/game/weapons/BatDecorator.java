package game.weapons;

import game.characters.Character;
import game.characters.CharacterDecorator;
import game.combat.Move;

public class BatDecorator extends CharacterDecorator {

    public BatDecorator(Character wrapped) {
        super(wrapped);
        name = "Bat";
        moves.add(new Move("🏏 Bat Slash", 8, 18, 0.85));
    }
}
