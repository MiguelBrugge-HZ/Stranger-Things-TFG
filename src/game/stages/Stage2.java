package game.stages;

import game.combat.CombatFacade;
import game.scenes.Scene;
import game.scenes.SchoolScene;
import game.scenes.transitions.TransitionToSchool;

public class Stage2 extends GameStage {
    @Override
    Scene createScene() { return new SchoolScene(new CombatFacade()); }

    @Override
    public void playTransition() {
        TransitionToSchool.play();
    }
}
