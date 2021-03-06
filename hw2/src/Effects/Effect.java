package Effects;

import Units.Unit;

public abstract class Effect {
    protected int damage;
    protected int heal;
    protected Unit activator;
    protected Unit target;

    public Effect(Unit activator, Unit target, int damage, int heal) {
        this.activator = activator;
        this.target = target;
        this.damage = damage;
        this.heal = heal;
    }

    public abstract void trigger();

    public Unit getTarget() {
        return target;
    }
}
