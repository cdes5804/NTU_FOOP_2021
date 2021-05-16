package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Unit;
import Entities.Troop;
import Utils.Utils;
import tw.waterball.foop.hw2.provided.AI;

public class BasicAttack extends SkillBase {
    public BasicAttack() {
        super(0, 1, 0, 0);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop, AI ai) {
        List<Integer> indices = Utils.getTarget(activeUnit, numTarget, oppositeTroop, ai);
        for (int index : indices) {
            oppositeTroop.getUnits().get(index).decreaseHp(totalDamage(activeUnit));
        }
    }

    @Override
    public String toString() {
        return "Basic Attack";
    }
}