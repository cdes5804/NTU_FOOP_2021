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
        target.setState(new Normal(target));
    }

    @Override
    public String toString() {
        return "Cheerup";
    }
}
