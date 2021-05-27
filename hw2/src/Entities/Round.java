package Entities;

import Units.Unit;

public class Round {
    Troop troopOne;
    Troop troopTwo;

    public Round(Troop troopOne, Troop troopTwo) {
        this.troopOne = troopOne;
        this.troopTwo = troopTwo;
    }

    private boolean isRoundOver() {
        return troopOne.isAnnihilated() || troopTwo.isAnnihilated();
    }

    private void updateUnitsState(Troop troop) {
        for (Unit unit : troop.getUnits()) {
            unit.getState().decreaseRemainingRound();
        }
    }

    private void turn(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        if (!activeUnit.isAlive()) {
            return;
        }

        System.out.printf("%s's turn (HP: %d, MP: %d, STR: %d, State: %s).\n",
                            activeUnit.getName(), activeUnit.getHp(), activeUnit.getMp(),
                            activeUnit.getStrength(), activeUnit.getState().toString());

        activeUnit.getState().takeEffect();

        if (activeUnit.isAlive() && activeUnit.canMove()) {
            activeUnit.action(activeTroop, oppositeTroop);
        }
    }

    public void start() {
        int current = 0;
        while (current < troopOne.getUnits().size()) {
            Unit activeUnit = troopOne.getUnits().get(current);
            turn(activeUnit, troopOne, troopTwo);

            if (isRoundOver()) {
                return;
            }

            current++;
        }

        current = 0;
        while (current < troopTwo.getUnits().size()) {
            Unit activeUnit = troopTwo.getUnits().get(current);
            turn(activeUnit, troopTwo, troopOne);

            if (isRoundOver()) {
                return;
            }

            current++;
        }

        updateUnitsState(troopOne);
        updateUnitsState(troopTwo);
    }
}
