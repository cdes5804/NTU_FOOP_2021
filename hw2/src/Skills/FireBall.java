package Skills;

import java.util.List;
import Entities.Troop;
import Entities.Unit;
import Utils.Utils;
import Utils.Writer;

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
        List<Unit> availableTargets = Utils.getAvailableTargets(activeUnit, oppositeTroop);

        Writer.writePerformMessage(this, activeUnit, availableTargets, null);

        for (Unit unit : availableTargets) {
            Writer.writeDamage(totalDamage(activeUnit), activeUnit, unit);
            unit.decreaseHp(totalDamage(activeUnit));
        }
    }

    @Override
    public String toString() {
        return "Fireball";
    }
}
