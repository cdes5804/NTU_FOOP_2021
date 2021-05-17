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

    public void start() {
        troopOne.action(troopTwo);
        if (isRoundOver(troopOne, troopTwo)) {
            return;
        }

        troopTwo.action(troopOne);
        if (isRoundOver(troopOne, troopTwo)) {
            return;
        }

        troopOne.updateUnitsState();
        troopTwo.updateUnitsState();
    }
}
