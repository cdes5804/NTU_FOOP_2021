package States;

import Units.Unit;

public class Poisoned extends State {
    public Poisoned(Unit target) {
        super(target);
    }

    @Override
    public void takeEffect() {
        target.decreaseHp(30);
    }

    @Override
    public String toString() {
        return "Poisoned";
    }
}
