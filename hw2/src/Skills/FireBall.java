package Skills;

import Entities.Troop;
import Entities.Unit;

public class FireBall extends SkillBase {
    public FireBall() {
        super(50, 0, 50, 0);
    }

    @Override
    public FireBall create() {
        return new FireBall();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        for (Unit unit : oppositeTroop.getUnits()) {
            if (unit.isAlive()) {
                unit.decreaseHp(totalDamage(activeUnit));
            }
        }
    }

    @Override
    public String toString() {
        return "FireBall";
    }
}
