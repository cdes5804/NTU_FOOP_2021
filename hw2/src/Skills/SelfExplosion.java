package Skills;

import java.util.stream.*;
import java.util.List;
import Entities.Troop;
import Entities.Unit;
import Utils.Utils;
import Utils.Writer;

public class SelfExplosion extends SkillBase {
    public SelfExplosion() {
        super(200, 0, 150, 0);
    }

    @Override
    public SelfExplosion create() {
        return new SelfExplosion();
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        Troop troopOne = activeTroop.getUnits().get(0).getName().equals("[1]Hero") ? activeTroop : oppositeTroop;
        Troop troopTwo = activeTroop.getUnits().get(0).getName().equals("[1]Hero") ? oppositeTroop : activeTroop;

        List<Unit> allUnits = Stream.concat(Utils.getAvailableTargets(activeUnit, troopOne).stream().filter(unit -> unit != activeUnit),
                                            Utils.getAvailableTargets(activeUnit, troopTwo).stream().filter(unit -> unit != activeUnit))
                                    .collect(Collectors.toList());
        
        Writer.writePerformMessage(this, activeUnit, allUnits, null);

        for (Unit unit : allUnits) {
            Writer.writeDamage(totalDamage(activeUnit), activeUnit, unit);
            unit.decreaseHp(totalDamage(activeUnit));
        }

        activeUnit.decreaseHp(activeUnit.getHp());
    }

    @Override
    public String toString() {
        return "SelfExplosion";
    }
}
