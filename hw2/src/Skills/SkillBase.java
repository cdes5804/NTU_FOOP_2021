package Skills;

import Entities.Unit;

public abstract class SkillBase {
    private int requiredMp;
    private int numTarget;
    private int damage;
    private int heal;

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
