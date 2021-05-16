package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Unit;
import Entities.Troop;

public class WaterBall extends SkillBase implements Action {
    public WaterBall() {
        super(50, 1, 120, 1);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);
        
        int totalDamage = damage + (activeUnit.isCheeredUp() ? 50 : 0);

        List<Integer> indices = new ArrayList<Integer>();
        for (int index : indices) {
            oppositeTroop.units.get(index).decreaseHp(totalDamage);
        }
    }
}
