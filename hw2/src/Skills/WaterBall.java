package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;
import Utils.Writer;

public class WaterBall extends SkillBase {
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

        Writer.writePerformMessage(this, activeUnit, targets);

        Unit target = targets.get(0);

        Writer.writeDamage(totalDamage(activeUnit), activeUnit, target);
        target.decreaseHp(totalDamage(activeUnit));
    }

    @Override
    public String toString() {
        return "Waterball";
    }
}
