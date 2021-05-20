package Skills;

import java.util.List;
import Entities.Troop;
import Entities.Unit;
import Effects.EffectBase;
import Effects.Heal;
import Utils.Utils;
import Utils.Writer;

public class Curse extends SkillBase {
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

        List<Unit> targets = Utils.getTargets(activeUnit, numTarget, oppositeTroop.getUnits());

        Writer.writePerformMessage(this, activeUnit, targets);

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
