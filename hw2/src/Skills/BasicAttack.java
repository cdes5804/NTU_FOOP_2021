package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;

public class BasicAttack extends Skill {
    public BasicAttack() {
        super(0, 1, 0, 0);
    }

    @Override
    public BasicAttack create() {
        return new BasicAttack();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        List<Unit> targets = activeUnit.selectTargets(numTarget, oppositeTroop.getUnits());
        printPerformMessage(activeUnit, targets);
        Unit targetUnit = targets.get(0);
        printDamageMessage(getDamage() + activeUnit.getStrength(), activeUnit, targetUnit);
        targetUnit.decreaseHp(getDamage() + activeUnit.getStrength());
    }

    @Override
    public String toString() {
        return "Basic Attack";
    }

    @Override
    protected void printPerformMessage(Unit activeUnit, List<Unit> targets) {
        Unit target = targets.get(0);
        System.out.printf("%s attacks %s.\n", activeUnit.getName(), target.getName());
    }
}