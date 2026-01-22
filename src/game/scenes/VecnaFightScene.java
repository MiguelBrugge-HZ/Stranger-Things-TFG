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

    @Override
    protected void fightScene() {
        Character vecna = new Vecna();
        combatFacade.fight(player, vecna);
    }

    @Override
    protected Scene endScene() {
        if (!player.isAlive()) {
            Scene end = new EndScene(false);
            end.setPlayer(player);
            return end;
        }

        new EndingTransitionDialog().play();

        Scene end = new EndScene(true);
        end.setPlayer(player);
        return end;
    }
}
