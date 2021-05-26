package States;

import Units.Unit;

public class Normal extends StateBase {
    public Normal(Unit target) {
        super(target);
    }

    @Override
    public String toString() {
        return "Normal";
    }
}
