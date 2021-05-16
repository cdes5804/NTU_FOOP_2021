package States;

import Entities.Unit;

public class Cheerup extends StateBase {
    public Cheerup(Unit target) {
        super(target);
    }

    @Override
    public void takeEffect() {
        target.setCheeredUp(true);
    }

    @Override
    public void clearState() {
        target.setCheeredUp(false);
    }

    @Override
    public String toString() {
        return "Cheerup";
    }
}
