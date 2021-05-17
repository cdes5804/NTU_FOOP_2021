package States;

import Entities.Unit;

public class Petrochemical extends StateBase {
    public Petrochemical(Unit target) {
        super(target);
    }

    @Override
    public void takeEffect() {
        target.setPetrified(true);
    }

    @Override
    public void clearState() {
        target.setPetrified(false);
    }

    @Override
    public String toString() {
        return "Petrochemical";
    }
}
