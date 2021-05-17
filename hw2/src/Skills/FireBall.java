package Skills;

import Entities.Troop;
import Entities.Unit;
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

        Writer.writePerformMessage(this, activeUnit, oppositeTroop.getUnits(), null);

        for (Unit unit : oppositeTroop.getUnits()) {
            Writer.writeDamage(totalDamage(activeUnit), activeUnit, unit);
            unit.decreaseHp(totalDamage(activeUnit));
        }
    }

    @Override
    public String toString() {
        return "Fireball";
    }
}
