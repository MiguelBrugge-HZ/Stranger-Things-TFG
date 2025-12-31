package game.stages;

import game.combat.CombatFacade;
import game.scenes.Scene;
import game.scenes.VecnaFightScene;
import game.scenes.dialog.transition.VecnaFightTransitionDialog;

public class Stage4 extends GameStage{
    @Override
    Scene createScene() { return new VecnaFightScene(new CombatFacade()); }
}
