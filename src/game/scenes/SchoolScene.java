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

    @Override
    protected void fightScene() {
        Character demogorgon = new Demogorgon();
        combatFacade.fight(player, demogorgon);
    }

    @Override
    protected Scene endScene() {
        if (!player.isAlive()) {
            Scene end = new EndScene(false);
            end.setPlayer(player);
            return end;
        }

        Scene next = new UpsideDownScene(combatFacade);
        next.setPlayer(player);
        return next;
    }
}
