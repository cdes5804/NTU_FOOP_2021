package States;

import Entities.Unit;

public class Cheerup extends StateBase {
    public Cheerup(Unit target) {
        super(target);
    }

    @Override
    public void takeEffect() {
        target.setBonusDamage(50);
    }

    @Override
    public void clearState() {
        target.setBonusDamage(0);
    }

    @Override
    public String toString() {
        return "Cheerup";
    }
}
