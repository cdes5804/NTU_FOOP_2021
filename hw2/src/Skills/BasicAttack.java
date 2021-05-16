package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Unit;
import Entities.Troop;

public class BasicAttack extends SkillBase implements Action {
    public BasicAttack() {
        super(0, 1, 0, 0);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        int totalDamage = damage + (activeUnit.isCheeredUp() ? 50 : 0);

        List<Integer> indices = new ArrayList<Integer>();
        for (int index : indices) {
            oppositeTroop.units.get(index).decreaseHp(totalDamage);
        }
    }
}