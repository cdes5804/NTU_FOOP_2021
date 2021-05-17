package States;

import Entities.Unit;

public class StateBase implements Effect {
    protected int remainingRound;
    protected Unit target;

    public StateBase(Unit target) {
        this.target = target;
        remainingRound = 3;
    }

    public void decreaseRemainingRound() {
        remainingRound -= 1;
        if (isOver()) {
            target.setState(new Normal(target));
        }
    }

    protected boolean isOver() {
        return remainingRound == 0;
    }

    @Override
    public void takeEffect() {
        return;
    }

    @Override
    public void clearState() {
    }
}