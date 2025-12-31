package game.scenes;

import game.characters.Character;
import game.characters.enemies.Demogorgon;
import game.combat.CombatFacade;

public class SchoolScene extends BattleScene {
    public SchoolScene(CombatFacade combatFacade) {
        super(combatFacade);
    }

    @Override
    public Character play() {
        System.out.println("Stage 2 -- School");
        startScene();
        fightDemogorgonScene();
        endScene();
        return player;
    }

    @Override
    public void startScene() {
        System.out.println("SchoolScene play");
    }

    public void fightDemogorgonScene() {
        Character demogorgon = new Demogorgon();
        combatFacade.fight(player, demogorgon);
    }

    @Override
    public void endScene() {
        System.out.println("SchoolScene end");
    }
}
