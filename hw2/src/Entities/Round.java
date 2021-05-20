package Entities;

public class Round {
    Troop troopOne;
    Troop troopTwo;

    public Round(Troop troopOne, Troop troopTwo) {
        this.troopOne = troopOne;
        this.troopTwo = troopTwo;
    }

    private boolean isRoundOver(Troop troopOne, Troop troopTwo) {
        return troopOne.isAnnihilated() || troopTwo.isAnnihilated();
    }

    private void updateUnitsState(Troop troop) {
        for (Unit unit : troop.getUnits()) {
            unit.getState().decreaseRemainingRound();
        }
    }

    public void start() {
        troopOne.action(troopTwo);
        if (isRoundOver(troopOne, troopTwo)) {
            return;
        }

        troopTwo.action(troopOne);
        if (isRoundOver(troopOne, troopTwo)) {
            return;
        }

        updateUnitsState(troopOne);
        updateUnitsState(troopTwo);
    }
}
