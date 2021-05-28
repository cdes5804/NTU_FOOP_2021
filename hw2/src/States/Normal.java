package States;

import Units.Unit;

public class Normal extends State {
    public Normal(Unit target) {
        super(target);
    }

    @Override
    public String toString() {
        return "Normal";
    }
}
