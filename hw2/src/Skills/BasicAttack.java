package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Unit;
import Entities.Troop;
import Utils.Utils;
import Utils.Writer;

public class BasicAttack extends SkillBase {
    public BasicAttack() {
        super(0, 1, 0, 0);
    }

    @Override
    public BasicAttack create() {
        return new BasicAttack();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        List<Unit> targets = Utils.getTargets(activeUnit, numTarget, oppositeTroop.getUnits());

        Writer.writePerformMessage(this, activeUnit, targets);

        Unit targetUnit = targets.get(0);
        Writer.writeDamage(totalDamage(activeUnit) + activeUnit.getStrength(), activeUnit, targetUnit);
        targetUnit.decreaseHp(totalDamage(activeUnit) + activeUnit.getStrength());
    }

    @Override
    public String toString() {
        return "Basic Attack";
    }
}