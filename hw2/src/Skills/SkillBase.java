package Skills;

import Entities.Unit;

public abstract class SkillBase {
    protected int requiredMp;
    protected int numTarget;
    protected int damage;
    protected int heal;

    SkillBase(int requiredMp, int numTarget, int damage, int heal) {
        this.requiredMp = requiredMp;
        this.numTarget = numTarget;
        this.damage = damage;
        this.heal = heal;
    }

    public boolean available(Unit activeUnit) {
        return activeUnit.getMP() >= requiredMp;
    }
}
