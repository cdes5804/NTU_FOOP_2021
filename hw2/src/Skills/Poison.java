package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;

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

        List<Integer> indices = new ArrayList<Integer>();
        for (int index : indices) {
            Unit target = oppositeTroop.getUnits().get(index);
            target.setState(new States.Poisoned(target));
        }
    }

    @Override
    public String toString() {
        return "Poison";
    }
}
