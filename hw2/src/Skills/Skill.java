package Skills;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Units.Unit;
import Utils.Utils;
import tw.waterball.foop.hw2.provided.AI;

public abstract class Skill implements Action {
    protected int requiredMp;
    protected int numTarget;
    protected int damage;
    protected int heal;
    protected int damageDelta;

    Skill(int requiredMp, int numTarget, int damage, int heal) {
        this.requiredMp = requiredMp;
        this.numTarget = numTarget;
        this.damage = damage;
        this.heal = heal;
    }

    public void setDamageDelta(int amount) {
        damageDelta = amount;
    }

    public int getDamage() {
        return damage + damageDelta;
    }

    public boolean available(Unit activeUnit) {
        return activeUnit.getMp() >= requiredMp;
    }

    protected void printPerformMessage(Unit activeUnit, List<Unit> targets) {
        List<String> targetNames = Utils.getTargetUnitsName(targets);
        String message = String.format("%s uses %s on ", activeUnit.getName(), toString())
                            + String.join(", ", targetNames) + ".";

        System.out.println(message);
    }

    protected void printDamageMessage(int damage, Unit activeUnit, Unit targetUnit) {
        System.out.printf("%s causes %d damage to %s.\n", activeUnit.getName(), damage, targetUnit.getName());
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        return;
    }
}
