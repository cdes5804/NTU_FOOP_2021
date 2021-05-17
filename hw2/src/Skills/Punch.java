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

        List<Integer> indices = Utils.getTargets(activeUnit, numTarget, oppositeTroop);

        Writer.writePerformMessage(this, activeUnit, oppositeTroop.getUnits(), indices);

        OnePunch onePunch = new OnePunch();
        onePunch.perform(activeUnit); // record how much damage OnePunch deals
        int totalDamage = totalDamage(activeUnit) + activeUnit.getOnePunchDamage();
        Unit targetUnit = oppositeTroop.getUnits().get(indices.get(0));

        Writer.writeDamage(totalDamage, activeUnit, targetUnit);
        targetUnit.decreaseHp(totalDamage);
    }

    @Override
    public String toString() {
        return "OnePunch";
    }
}
