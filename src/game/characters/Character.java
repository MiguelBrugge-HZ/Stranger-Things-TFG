package game.characters;

import game.combat.Move;
import game.utils.InputManager;

import java.util.List;
import java.util.Random;

public abstract class Character {
    protected String name;
    private int health;
    protected final List<Move> moves;

    protected Character(String name, int health,  List<Move> moves) {
        this.name = name;
        this.health = health;
        this.moves = moves;
    }

    public Move chooseMove() {
        if (moves == null || moves.isEmpty()) {
            throw new IllegalStateException("No moves defined for " + name);
        }
        return InputManager.getInstance().chooseOption("-- Choose your move:", moves);
    }

    public Move chooseRandomMove() {
        Random random = new Random();
        return moves.get(random.nextInt(moves.size()));
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void heal() {
        this.setHealth(this.getHealth() + 40);
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Move> getMoves() {
        return this.moves;
    }

    @Override
    public String toString() {
        return name;
    }
}
