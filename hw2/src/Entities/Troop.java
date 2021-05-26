package Entities;

import java.util.List;
import Units.Unit;

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
}
