package Skills;

import java.util.List;
import java.util.Arrays;
import Entities.Troop;
import Units.Unit;
import Utils.Utils;
import Units.UnitFactory;

public class Summon extends Skill {
    private UnitFactory factory;

    public Summon(UnitFactory factory) {
        super(150, 0, 0, 0);
        this.factory = factory;
    }

    @Override
    public Summon create() {
        return new Summon(factory);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);
        printPerformMessage(activeUnit, null);
        /* Slime stats */
        int hp = 100;
        int mp = 0;
        int str = 50;
        List<Skill> skills = Arrays.asList(new BasicAttack());

        Unit slime = factory.create(hp, mp, str, "Slime", skills);
        activeTroop.addAlly(slime);
    }

    @Override
    public String toString() {
        return "Summon";
    }

    @Override
    protected void printPerformMessage(Unit activeUnit, List<Unit> targets) {
        System.out.printf("%s uses %s.\n", activeUnit.getName(), toString());
    }
}
