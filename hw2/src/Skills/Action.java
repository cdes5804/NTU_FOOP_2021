package Skills;

import Entities.Unit;
import Entities.Troop;

public interface Action {
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop);
    public SkillBase create();
}
