package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;
import Utils.Writer;
import tw.waterball.foop.hw2.provided.OnePunch;
import tw.waterball.foop.hw2.provided.Target;

class PunchAccepter implements Target {
    private int punchDamage;

    public PunchAccepter() {
        punchDamage = 0;
    }

    public int getPunchDamage() {
        return punchDamage;
    }

    @Override
    public void takeOnePunchDamage(int damage) {
        punchDamage = damage;
    }
}

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
        OnePunch onePunch = new OnePunch();
        PunchAccepter accepter = new PunchAccepter();

        List<Unit> targets = activeUnit.selectTargets(numTarget, oppositeTroop.getUnits());

        Writer.writePerformMessage(this, activeUnit, targets);

        Unit target = targets.get(0);
        onePunch.perform(accepter);
        int totalDamage = totalDamage(activeUnit) + accepter.getPunchDamage();

        Writer.writeDamage(totalDamage, activeUnit, target);
        target.decreaseHp(totalDamage);
    }

    @Override
    public String toString() {
        return "OnePunch";
    }
}
