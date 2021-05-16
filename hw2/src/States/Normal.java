package States;

import Entities.Unit;

public class Normal extends StateBase {
    public Normal(Unit target) {
        super(target);
    }

    @Override
    public String toString() {
        return "Normal";
    }
}
