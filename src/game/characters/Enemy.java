package game.characters;
import game.combat.Move;
import java.util.List;


public abstract class Enemy extends Character{
    protected Enemy(String name, int health, List<Move> moves) {
        super(name, health, moves);
    }

    @Override
    public Move chooseMove() {
        return chooseRandomMove();
    }
}
