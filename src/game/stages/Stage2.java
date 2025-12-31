package game.stages;

import game.combat.CombatFacade;
import game.scenes.Scene;
import game.scenes.SchoolScene;
import game.scenes.dialog.transition.SchoolTransitionDialog;

public class Stage2 extends GameStage {
    @Override
    Scene createScene() { return new SchoolScene(new CombatFacade()); }
}
