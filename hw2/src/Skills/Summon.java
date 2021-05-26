package Skills;

import java.util.List;
import java.util.Arrays;
import Entities.Troop;
import Units.Unit;
import Utils.Utils;
import Utils.Writer;
import Units.AIUnitFactory;

public class Summon extends SkillBase {
    private AIUnitFactory factory;

    public Summon(AIUnitFactory factory) {
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
        Writer.writePerformMessage(this, activeUnit, null);
        /* Slime stats */
        int hp = 100;
        int mp = 0;
        int str = 50;
        List<SkillBase> skills = Arrays.asList(new BasicAttack());

        Unit slime = factory.create(hp, mp, str, Utils.getPrefix(activeUnit) + "Slime", skills);
        activeTroop.addAlly(slime);
    }

    @Override
    public String toString() {
        return "Summon";
    }
}
