package game.stages;

import game.combat.CombatFacade;
import game.scenes.Scene;
import game.scenes.UpsideDownScene;
import game.scenes.dialog.transition.UpsideDownTransitionDialog;

public class Stage3 extends GameStage{
    @Override
    Scene createScene() { return new UpsideDownScene(new CombatFacade()); }
}
