package States;

import java.lang.ref.Cleaner.Cleanable;

import Entities.Unit;

public class StateBase implements Effect {
    protected int remainingRound;
    protected Unit target;

    public StateBase(Unit target) {
        this.target = target;
        target.setState(this);
        remainingRound = 3;
    }

    public void decreaseRemainingRound() {
        remainingRound -= 1;
    }

    public boolean isOver() {
        return remainingRound == 0;
    }

    @Override
    public void takeEffect() {
        return;
    }

    @Override
    public void clearState() {
        return;
    }
}