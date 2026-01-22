package game.scenes;

import game.characters.Character;
import game.combat.CombatFacade;

public abstract class BattleScene extends Scene {

    protected CombatFacade combatFacade;

    protected BattleScene(CombatFacade combatFacade) {
        this.combatFacade = combatFacade;
    }

    @Override
    protected abstract void fightScene();
}