package game.scenes;

import game.characters.Character;
import game.characters.enemies.Vecna;
import game.combat.CombatFacade;

public class VecnaFightScene extends BattleScene {
    public VecnaFightScene(CombatFacade combatFacade) {
        super(combatFacade);
    }

    @Override
    public game.characters.Character play() {
        System.out.println("Stage 4 -- Final Fight");
        startScene();
        fightVecnaScene();
        endScene();
        return player;
    }

    @Override
    public void startScene() {
        System.out.println("VecnaFightScene play");
    }

    public void fightVecnaScene() {
        Character vecna = new Vecna();
        combatFacade.fight(player, vecna);
    }

    @Override
    public void endScene() {
        System.out.println("VecnaFightScene end");
    }

}
