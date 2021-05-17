package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;
import Utils.Utils;
import Utils.Writer;

public class Cheerup extends SkillBase {
    public Cheerup() {
        super(100, 1, 0, 0);
    }

    @Override
    public Cheerup create() {
        return new Cheerup();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Integer> indices = Utils.getTargets(activeUnit, numTarget, activeTroop);

        Writer.writePerformMessage(this, activeUnit, activeTroop.getUnits(), indices);

        for (int index : indices) {
            Unit target = activeTroop.getUnits().get(index);
            target.setState(new States.Cheerup(target));
        }
    }

    @Override
    public String toString() {
        return "Cheerup";
    }
}
