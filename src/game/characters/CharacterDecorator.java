package game.characters;

import game.combat.Move;
import java.util.ArrayList;

public abstract class CharacterDecorator extends Character {

    protected final Character wrapped;

    protected CharacterDecorator(Character wrapped) {
        super(
                wrapped.getName(),
                wrapped.getHealth(),
                new ArrayList<>(wrapped.getMoves())
        );
        this.wrapped = wrapped;
    }

    @Override
    public Move chooseMove() {
        return super.chooseMove();
    }
}
