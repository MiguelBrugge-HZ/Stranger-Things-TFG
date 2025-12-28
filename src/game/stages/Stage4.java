package game.stages;

import game.combat.CombatFacade;
import game.scenes.Scene;
import game.scenes.VecnaFightScene;
import game.scenes.transitions.TransitionToVecnaFight;

public class Stage4 extends GameStage{
    @Override
    Scene createScene() { return new VecnaFightScene(new CombatFacade()); }

    @Override
    public void playTransition() {
        TransitionToVecnaFight.play();
    }

}
