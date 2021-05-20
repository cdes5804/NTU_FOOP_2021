package States;

import Entities.Unit;

public class Petrochemical extends StateBase {
    public Petrochemical(Unit target) {
        super(target);
    }

    @Override
    public void takeEffect() {
        target.setCanMove(false);
    }

    @Override
    public void clearState() {
        target.setCanMove(true);
    }

    @Override
    public String toString() {
        return "Petrochemical";
    }
}
