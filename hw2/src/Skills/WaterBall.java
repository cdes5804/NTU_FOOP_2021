package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Unit;
import Entities.Troop;

public class WaterBall extends SkillBase {
    public WaterBall() {
        super(50, 1, 120, 1);
    }

    @Override
    public WaterBall create() {
        return new WaterBall();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Integer> indices = new ArrayList<Integer>();
        for (int index : indices) {
            oppositeTroop.getUnits().get(index).decreaseHp(totalDamage(activeUnit));
        }
    }

    @Override
    public String toString() {
        return "WaterBall";
    }
}
