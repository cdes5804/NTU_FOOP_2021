package Skills;

import Entities.Unit;
import Entities.Troop;

public class SkillBase implements Action {
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

    protected int totalDamage(Unit activeUnit) {
        return damage + (activeUnit.isCheeredUp() ? 50 : 0);
    }

    public boolean available(Unit activeUnit) {
        return activeUnit.getMP() >= requiredMp;
    }

    @Override
    public SkillBase create() {
        return null;
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        return;
    }
}
