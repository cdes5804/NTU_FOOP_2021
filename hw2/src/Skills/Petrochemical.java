package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;
import Utils.Utils;
import Utils.Writer;

public class Petrochemical extends SkillBase {
    public Petrochemical() {
        super(100, 1, 0, 0);
    }

    @Override
    public Petrochemical create() {
        return new Petrochemical();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Integer> indices = Utils.getTargets(activeUnit, numTarget, oppositeTroop);

        Writer.writePerformMessage(this, activeUnit, oppositeTroop.getUnits(), indices);

        Unit target = oppositeTroop.getUnits().get(indices.get(0));
        target.setState(new States.Petrochemical(target));
    }

    @Override
    public String toString() {
        return "Petrochemical";
    }
}
