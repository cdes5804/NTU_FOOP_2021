package Skills;

import java.util.List;
import java.util.ArrayList;
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

        List<Integer> indices = Utils.getTargets(activeUnit, numTarget, oppositeTroop);

        Writer.writePerformMessage(this, activeUnit, oppositeTroop.getUnits(), indices);

        Unit target = activeTroop.getUnits().get(indices.get(0));
        target.addCurse(activeUnit);
    }

    @Override
    public String toString() {
        return "Curse";
    }
}
