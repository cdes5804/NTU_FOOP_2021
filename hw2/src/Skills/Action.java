package Skills;

import java.util.List;
import Entities.Unit;
import Entities.Troop;

public interface Action {
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop);
}
