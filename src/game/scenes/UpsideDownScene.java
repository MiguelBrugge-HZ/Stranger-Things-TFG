package game.scenes;

import game.characters.Character;
import game.characters.enemies.Bat;
import game.combat.CombatFacade;
import game.scenes.dialog.intro.UpsideDownIntroDialog;
import game.scenes.dialog.transition.VecnaFightTransitionDialog;

public class UpsideDownScene extends BattleScene {

    public UpsideDownScene(CombatFacade combatFacade) {
        super(combatFacade);
    }

    @Override
    public void startScene() {
        new UpsideDownIntroDialog().play();
    }

    @Override
    protected void fightScene() {
        Character bat = new Bat();
        combatFacade.fight(player, bat);
    }

    @Override
    protected Scene endScene() {
        if (!player.isAlive()) {
            Scene end = new EndScene(false);
            end.setPlayer(player);
            return end;
        }

        new VecnaFightTransitionDialog().play();
        Scene next = new VecnaFightScene(combatFacade);
        next.setPlayer(player);
        return next;
    }
}
