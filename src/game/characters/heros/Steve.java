package game.characters.heros;
import game.characters.Hero;
import game.combat.Move;
import java.util.List;

public class Steve extends Hero {
    public Steve() {
        super("Steve", 130, List.of(
                new Move("🛡️ Shield Guard", 7, 14, 0.98),
                new Move("👊 Protective Punch", 13, 22, 0.9),
                new Move("🔥 Heroic Counter", 20, 35, 0.7)
        ));
    }
}
