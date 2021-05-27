package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;

public class SelfHealing extends Skill {
    public SelfHealing() {
        super(50, 0, 0, 150);
    }

    @Override
    public SelfHealing create() {
        return new SelfHealing();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        printPerformMessage(activeUnit, null);

        activeUnit.increaseHp(heal);
    }

    @Override
    public String toString() {
        return "SelfHealing";
    }

    @Override
    protected void printPerformMessage(Unit activeUnit, List<Unit> targets) {
        System.out.printf("%s uses %s.\n", activeUnit.getName(), toString());
    }
}
