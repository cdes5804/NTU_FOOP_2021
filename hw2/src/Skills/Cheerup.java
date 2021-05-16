package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;

public class Cheerup extends SkillBase {
    public Cheerup() {
        super(100, 1, 0, 0);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Integer> indices = new ArrayList<Integer>();
        for (int index : indices) {
            Unit target = activeTroop.units.get(index);
            target.setState(new States.Cheerup(target));
        }
    }
}
