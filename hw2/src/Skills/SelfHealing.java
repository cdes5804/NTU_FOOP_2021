package Skills;

import Entities.Troop;
import Entities.Unit;
import Utils.Writer;

public class SelfHealing extends SkillBase {
    public SelfHealing() {
        super(50, 0, 0, 150);
    }

    @Override
    public SkillBase create() {
        return new SelfHealing();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        Writer.writePerformMessage(this, activeUnit, null);

        activeUnit.increaseHp(heal);
    }

    @Override
    public String toString() {
        return "SelfHealing";
    }
}
