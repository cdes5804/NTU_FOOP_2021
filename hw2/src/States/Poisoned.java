package States;

import Entities.Unit;

public class Poisoned extends StateBase {
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
