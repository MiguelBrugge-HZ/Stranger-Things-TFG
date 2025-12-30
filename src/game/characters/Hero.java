package game.characters;
import game.combat.Move;
import java.util.List;

public class Hero extends Character{
    protected Hero(String name, int health, List<Move> moves) {
        super(name, health, moves);
    }
}
