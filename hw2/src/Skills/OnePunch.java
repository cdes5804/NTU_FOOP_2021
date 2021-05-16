package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;
import Utils.provided;

public class OnePunch extends SkillBase {
    public OnePunch() {
        super(180, 1, 0, 0);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Integer> indices = new ArrayList<Integer>();
        for (int index : indices) {
            provided.OnePunch punch = new provided.OnePunch();
            punch.perform(oppositeTroop.units.get(index));
        }
    }
}
