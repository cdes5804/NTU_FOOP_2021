package Skills;

import java.util.List;
import Entities.Troop;
import Entities.Unit;
import Utils.Utils;
import Utils.Writer;

public class Curse extends SkillBase {
    public Curse() {
        super(100, 1, 0, 0);
    }

    @Override
    public Curse create() {
        return new Curse();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Unit> targets = Utils.getTargets(activeUnit, numTarget, oppositeTroop.getUnits());

        Writer.writePerformMessage(this, activeUnit, targets);

        Unit target = targets.get(0);
        target.getCurser().addCurser(activeUnit);
    }

    @Override
    public String toString() {
        return "Curse";
    }
}
