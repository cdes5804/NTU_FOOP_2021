package Skills;

import Entities.Troop;
import Units.Unit;

public interface Action {
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop);
    public SkillBase create();
}
