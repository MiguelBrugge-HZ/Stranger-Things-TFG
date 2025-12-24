package game.scenes;

import game.combat.CombatFacade;

public abstract class BattleScene extends Scene{
    protected CombatFacade combatFacade;

    protected BattleScene(CombatFacade combatFacade) {
        this.combatFacade = combatFacade;
    }
}
