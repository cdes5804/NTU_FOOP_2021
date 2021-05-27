package Skills;

import java.util.List;
import Entities.Troop;
import Units.Unit;
import Effects.EffectBase;
import Effects.Heal;

public class Curse extends Skill {
    public Curse() {
        super(100, 1, 0, 0);
    }

    @Override
    public Curse create() {
        return new Curse();
    }

    private boolean hasExist(List<EffectBase> effects, Unit target) {
        for (EffectBase effect : effects) {
            if (effect.getTarget() == target && effect.toString().equals("Heal")) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        List<Unit> targets = activeUnit.selectTargets(numTarget, oppositeTroop.getUnits());

        printPerformMessage(activeUnit, targets);

        Unit target = targets.get(0);
        if (!hasExist(target.getDeathEffect(), target)) {
            target.addDeathEffect(new Heal(target, activeUnit, 0, 0));
        }
    }

    @Override
    public String toString() {
        return "Curse";
    }
}
