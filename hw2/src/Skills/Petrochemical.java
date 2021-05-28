package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;

public class Petrochemical extends Skill {
    public Petrochemical() {
        super(100, 1, 0, 0);
    }

    @Override
    public Petrochemical create() {
        return new Petrochemical();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Unit> targets = activeUnit.selectTargets(numTarget, oppositeTroop.getUnits());

        printPerformMessage(activeUnit, targets);

        Unit target = targets.get(0);
        target.setState(new States.Petrochemical(target));
    }

    @Override
    public String toString() {
        return "Petrochemical";
    }
}
