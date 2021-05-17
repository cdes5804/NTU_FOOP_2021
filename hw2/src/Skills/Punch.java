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

        List<Unit> availableTargets = Utils.getAvailableTargets(activeUnit, oppositeTroop);
        List<Integer> indices = Utils.getTargets(activeUnit, numTarget, availableTargets);

        Writer.writePerformMessage(this, activeUnit, availableTargets, indices);

        OnePunch onePunch = new OnePunch();
        Unit targetUnit = availableTargets.get(indices.get(0));
        onePunch.perform(targetUnit);
        int totalDamage = totalDamage(activeUnit) + targetUnit.getOnePunchDamage();

        Writer.writeDamage(totalDamage, activeUnit, targetUnit);
        targetUnit.decreaseHp(totalDamage);
    }

    @Override
    public String toString() {
        return "OnePunch";
    }
}
