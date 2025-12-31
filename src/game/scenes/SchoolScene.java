package game.scenes;

import game.characters.Character;
import game.characters.enemies.Demogorgon;
import game.combat.CombatFacade;
import game.scenes.dialog.intro.SchoolIntroDialog;
import game.scenes.dialog.transition.UpsideDownTransitionDialog;

public class SchoolScene extends BattleScene {
    public SchoolScene(CombatFacade combatFacade) {
        super(combatFacade);
    }

    @Override
    public void startScene() {
        new SchoolIntroDialog().play();
    }

    public void fightScene() {
        Character demogorgon = new Demogorgon();
        combatFacade.fight(player, demogorgon);
    }

    @Override
    public void endScene() {
        new UpsideDownTransitionDialog().play();
    }
}
