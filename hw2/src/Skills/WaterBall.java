package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;

public class WaterBall extends Skill {
    public WaterBall() {
        super(50, 1, 120, 1);
    }

    @Override
    public WaterBall create() {
        return new WaterBall();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Unit> targets = activeUnit.selectTargets(numTarget, oppositeTroop.getUnits());

        printPerformMessage(activeUnit, targets);

        Unit target = targets.get(0);

        printDamageMessage(getDamage(), activeUnit, target);
        target.decreaseHp(getDamage());
    }

    @Override
    public String toString() {
        return "Waterball";
    }
}
