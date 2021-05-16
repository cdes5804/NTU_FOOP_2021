package Skills;

import java.util.List;
import java.util.Arrays;
import Entities.Unit;
import Entities.Troop;

public class Summon extends SkillBase {
    public Summon() {
        super(150, 0, 0, 0);
    }

    @Override
    public Summon create() {
        return new Summon();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);
        /* Slime stats */
        int hp = 100;
        int mp = 0;
        int str = 50;
        List<SkillBase> skills = Arrays.asList(new BasicAttack());

        Unit slime = new Unit(hp, mp, str, "Slime", skills);
        activeTroop.addAlly(slime);
    }

    @Override
    public String toString() {
        return "Summon";
    }
}
