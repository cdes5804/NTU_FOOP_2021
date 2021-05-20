package Effects;

import Entities.Unit;

public class Heal extends EffectBase {
    public Heal(Unit activator, Unit target, int damage, int heal) {
        super(activator, target, 0, 0);
    }

    @Override
    public void trigger() {
        target.increaseHp(activator.getMp());
    }

    @Override
    public String toString() {
        return "Heal";
    }
}
