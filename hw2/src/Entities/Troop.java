package Entities;

import java.util.List;
import Utils.Writer;

public class Troop {
    private List<Unit> units;

    public Troop(List<Unit> units) {
        this.units = units;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void addAlly(Unit unit) {
        this.units.add(unit);
    }

    public boolean isAnnihilated() {
        return aliveCount() == 0
               || (units.get(0).getName().equals("[1]Hero") && !units.get(0).isAlive());
    }

    public int aliveCount() {
       return units.stream().filter(unit -> unit.isAlive()).toArray().length;
    }

    public void updateUnitsState() {
        for (Unit unit : units) {
            unit.getState().decreaseRemainingRound();
        }
    }

    public void action(Troop oppositeTroop) {
        int current = 0;
        
        while (current < units.size()) {
            Unit unit = units.get(current);

            if (unit.isAlive()) {
                Writer.writeTurn(unit);

                unit.getState().takeEffect();

                if (unit.isAlive() && !unit.isPetrified()) {
                    unit.action(this, oppositeTroop);
                }

                if (isAnnihilated() || oppositeTroop.isAnnihilated()) {
                    return;
                }
            }

            current++;
        }
    }
}
