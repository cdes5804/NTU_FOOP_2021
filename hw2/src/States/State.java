package States;

import Units.Unit;

public abstract class State implements Effect {
    protected int remainingRound;
    protected Unit target;

    public State(Unit target) {
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