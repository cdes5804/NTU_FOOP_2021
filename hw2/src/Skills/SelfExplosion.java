package Skills;

import java.util.stream.*;
import java.util.List;
import Entities.Troop;
import Entities.Unit;

public class SelfExplosion extends SkillBase {
    public SelfExplosion() {
        super(200, 0, 150, 0);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);

        Troop troopOne = null;
        Troop troopTwo = null;
        if (activeTroop.units.get(0).getName() == "Hero") {
            troopOne = activeTroop;
            troopTwo = oppositeTroop;
        } else {
            troopOne = oppositeTroop;
            troopTwo = activeTroop;
        }

        List<Unit> allUnits = Stream.concat(troopOne.units.stream(), troopTwo.units.stream())
                             .collect(Collectors.toList());

        for (Unit unit : allUnits) {
            if (unit == activeUnit)
                continue;
            unit.decreaseHp(totalDamage(activeUnit));
        }
    }
}
