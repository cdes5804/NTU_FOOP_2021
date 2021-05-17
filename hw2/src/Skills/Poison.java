package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;
import Utils.Utils;
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

        List<Integer> indices = Utils.getTargets(activeUnit, numTarget, oppositeTroop);

        Writer.writePerformMessage(this, activeUnit, oppositeTroop.getUnits(), indices);

        Unit targetUnit = oppositeTroop.getUnits().get(indices.get(0));
        targetUnit.setState(new States.Poisoned(targetUnit));
    }

    @Override
    public String toString() {
        return "Poison";
    }
}
