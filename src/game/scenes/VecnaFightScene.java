package game.scenes;

import game.characters.Character;
import game.characters.enemies.Vecna;
import game.combat.CombatFacade;
import game.scenes.dialog.intro.VecnaFightIntroDialog;
import game.scenes.dialog.transition.EndingTransitionDialog;

public class VecnaFightScene extends BattleScene {
    public VecnaFightScene(CombatFacade combatFacade) {
        super(combatFacade);
    }

    @Override
    public void startScene() {
        new VecnaFightIntroDialog().play();
    }

    public void fightScene() {
        Character vecna = new Vecna();
        combatFacade.fight(player, vecna);
    }

    @Override
    public void endScene() {
        new EndingTransitionDialog().play();
    }
}
