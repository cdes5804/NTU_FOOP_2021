package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Entities.Unit;
import Utils.Utils;
import Utils.Writer;
import tw.waterball.foop.hw2.provided.OnePunch;

public class Punch extends SkillBase {
    public Punch() {
        super(180, 1, 0, 0);
    }

    @Override
    public Punch create() {
        return new Punch();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Unit> targets = Utils.getTargets(activeUnit, numTarget, oppositeTroop.getUnits());

        Writer.writePerformMessage(this, activeUnit, targets);

        OnePunch onePunch = new OnePunch();
        Unit target = targets.get(0);
        onePunch.perform(target);
        int totalDamage = totalDamage(activeUnit) + target.getOnePunchDamage();

        Writer.writeDamage(totalDamage, activeUnit, target);
        target.decreaseHp(totalDamage);
    }

    @Override
    public String toString() {
        return "OnePunch";
    }
}
