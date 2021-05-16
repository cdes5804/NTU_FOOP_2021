package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;
import tw.waterball.foop.hw2.provided.OnePunch;

public class Punch extends SkillBase {
    public Punch() {
        super(180, 1, 0, 0);
    }

    @Override
    public Punch create() {
        return new Punch();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Integer> indices = new ArrayList<Integer>();
        for (int index : indices) {
            OnePunch onePunch = new OnePunch();
            onePunch.perform(oppositeTroop.getUnits().get(index));
        }
    }

    @Override
    public String toString() {
        return "OnePunch";
    }
}
