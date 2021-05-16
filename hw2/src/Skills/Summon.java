package Skills;

import Entities.Unit;
import Entities.Troop;

public class Summon extends SkillBase {
    public Summon() {
        super(150, 0, 0, 0);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);
        /* Slime stats */
        int hp = 100;
        int mp = 0;
        int str = 50;

        Unit slime = new Unit(hp, mp, str, "Slime");
        activeTroop.addAlly(slime);
    }
}
