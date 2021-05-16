package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;

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

        List<Integer> indices = new ArrayList<Integer>();
        for (int index : indices) {
            Unit target = oppositeTroop.getUnits().get(index);
            target.setState(new States.Petrochemical(target));
        }
    }

    @Override
    public String toString() {
        return "Petrochemical";
    }
}
