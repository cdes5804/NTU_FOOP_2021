package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;
import Utils.Utils;

public class FireBall extends Skill {
    public FireBall() {
        super(50, -1, 50, 0);
    }

    @Override
    public FireBall create() {
        return new FireBall();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);
        List<Unit> targets = Utils.getAvailableTargets(activeUnit, oppositeTroop.getUnits());

        printPerformMessage(activeUnit, targets);

        for (Unit unit : targets) {
            printDamageMessage(getDamage(), activeUnit, unit);
            unit.decreaseHp(getDamage());
        }
    }

    @Override
    public String toString() {
        return "Fireball";
    }
}
