package game.scenes;

import game.characters.Character;
import game.characters.enemies.Bat;
import game.combat.CombatFacade;
import game.scenes.transitions.TransitionToVecnaFight;

public class UpsideDownScene extends BattleScene{
    public UpsideDownScene(CombatFacade combatFacade) {
        super(combatFacade);
    }

    @Override
    public game.characters.Character play() {
        System.out.println("Stage 3 -- Upside Down");
        startScene();
        fightBatScene();
        endScene();
        return player;
    }

    @Override
    public void startScene() {
        System.out.println("UpsideDownScene play");
    }

    public void fightBatScene() {
        Character bat = new Bat();
        combatFacade.fight(player, bat);
    }

    @Override
    public void endScene() {
        System.out.println("UpsideDownScene end");
    }

}
