package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;
import Utils.Writer;

public class Poison extends SkillBase {
    public Poison() {
        super(80, 1, 0, 0);
    }

    @Override
    public Poison create() {
        return new Poison();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Unit> targets = activeUnit.selectTargets(numTarget, oppositeTroop.getUnits());

        Writer.writePerformMessage(this, activeUnit, targets);

        Unit target = targets.get(0);
        target.setState(new States.Poisoned(target));
    }

    @Override
    public String toString() {
        return "Poison";
    }
}
