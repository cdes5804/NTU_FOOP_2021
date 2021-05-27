package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;

public class Cheerup extends Skill {
    public Cheerup() {
        super(100, 3, 0, 0);
    }

    @Override
    public Cheerup create() {
        return new Cheerup();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Unit> targets = activeUnit.selectTargets(numTarget, activeTroop.getUnits());

        printPerformMessage(activeUnit, targets);

        for (Unit target : targets) {
            target.setState(new States.Cheerup(target));
        }
    }

    @Override
    public String toString() {
        return "Cheerup";
    }
}
