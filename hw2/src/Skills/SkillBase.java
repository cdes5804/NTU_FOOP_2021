package Skills;

import Entities.Troop;
import Units.Unit;
import tw.waterball.foop.hw2.provided.AI;

public abstract class SkillBase implements Action {
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

    public int totalDamage(Unit activeUnit) {
        return damage + activeUnit.getBonusDamage();
    }

    public int getDamage() {
        return damage;
    }

    public boolean available(Unit activeUnit) {
        return activeUnit.getMp() >= requiredMp;
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        return;
    }
}
