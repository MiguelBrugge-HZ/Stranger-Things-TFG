package game.stages;

import game.combat.CombatFacade;
import game.scenes.Scene;
import game.scenes.UpsideDownScene;
import game.scenes.transitions.TransitionToUpsideDown;

public class Stage3 extends GameStage{
    @Override
    Scene createScene() { return new UpsideDownScene(new CombatFacade()); }

    @Override
    public void playTransition() {
        TransitionToUpsideDown.play();
    }

}
