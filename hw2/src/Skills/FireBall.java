package Skills;

import java.util.List;
import Entities.Troop;
import Entities.Unit;
import Utils.Utils;
import Utils.Writer;

public class FireBall extends SkillBase {
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

        Writer.writePerformMessage(this, activeUnit, targets);

        for (Unit unit : targets) {
            Writer.writeDamage(totalDamage(activeUnit), activeUnit, unit);
            unit.decreaseHp(totalDamage(activeUnit));
        }
    }

    @Override
    public String toString() {
        return "Fireball";
    }
}
