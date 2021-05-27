package Skills;

import java.util.stream.*;
import java.util.List;
import java.util.Collection;
import Entities.Troop;
import Units.Unit;
import Utils.Utils;

public class SelfExplosion extends Skill {
    public SelfExplosion() {
        super(200, -1, 150, 0);
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
        List<Unit> allUnits = Stream.of(troopOne.getUnits(), troopTwo.getUnits()).flatMap(Collection::stream).collect(Collectors.toList());

        List<Unit> targets = Utils.getAvailableTargets(activeUnit, allUnits);
        
        printPerformMessage(activeUnit, targets);

        for (Unit target : targets) {
            printDamageMessage(getDamage(), activeUnit, target);
            target.decreaseHp(getDamage());
        }

        activeUnit.decreaseHp(activeUnit.getHp());
    }

    @Override
    public String toString() {
        return "SelfExplosion";
    }
}
