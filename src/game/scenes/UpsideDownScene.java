package game.scenes;

import game.characters.Character;
import game.characters.enemies.Bat;
import game.combat.CombatFacade;
import game.scenes.dialog.intro.UpsideDownIntroDialog;
import game.scenes.dialog.transition.UpsideDownTransitionDialog;
import game.scenes.dialog.transition.VecnaFightTransitionDialog;

public class UpsideDownScene extends BattleScene{
    public UpsideDownScene(CombatFacade combatFacade) {
        super(combatFacade);
    }

    @Override
    public void startScene() {
        new UpsideDownIntroDialog().play();
    }

    public void fightScene() {
        Character bat = new Bat();
        combatFacade.fight(player, bat);
    }

    @Override
    public void endScene() {
        new VecnaFightTransitionDialog().play();
    }
}
