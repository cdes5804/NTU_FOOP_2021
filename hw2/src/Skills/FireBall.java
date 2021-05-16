package Skills;

import Entities.Troop;
import Entities.Unit;

public class FireBall extends SkillBase implements Action {
    public FireBall() {
        super(50, 0, 50, 0);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        int totalDamage = damage + (activeUnit.isCheeredUp() ? 50 : 0);
        for (Unit unit : oppositeTroop.units) {
            if (unit.isAlive()) {
                unit.decreaseHp(totalDamage);
            }
        }
    }
}
