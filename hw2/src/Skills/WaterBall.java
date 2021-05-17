package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Unit;
import Entities.Troop;
import Utils.Utils;
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

        List<Integer> indices = Utils.getTargets(activeUnit, numTarget, oppositeTroop);

        Writer.writePerformMessage(this, activeUnit, oppositeTroop.getUnits(), indices);

        Unit targetUnit = oppositeTroop.getUnits().get(indices.get(0));

        Writer.writeDamage(totalDamage(activeUnit), activeUnit, targetUnit);
        targetUnit.decreaseHp(totalDamage(activeUnit));
    }

    @Override
    public String toString() {
        return "Waterball";
    }
}
