package game.scenes;

import game.characters.Character;
import game.combat.CombatFacade;

public abstract class BattleScene extends Scene{
    protected CombatFacade combatFacade;

    protected BattleScene(CombatFacade combatFacade) {
        this.combatFacade = combatFacade;
    }

    protected abstract void fightScene();

    public Character play() {
        startScene();
        fightScene();
        if(!player.isAlive()) return player;
        endScene();
        return player;
    }
}
