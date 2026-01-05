package game.characters;

public abstract class CharacterDecorator extends Character {

    protected final Character wrapped;

    protected CharacterDecorator(Character wrapped) {
        super(wrapped.getName(), 0, wrapped.getMoves());
        this.wrapped = wrapped;
    }

    @Override
    public int getHealth() {
        return wrapped.getHealth();
    }

    @Override
    public void setHealth(int health) {
        wrapped.setHealth(health);
    }

    @Override
    public boolean isAlive() {
        return wrapped.isAlive();
    }
}
