package Entities;

import java.util.List;
import java.util.ArrayList;
import Units.Unit;

public class Troop {
    private List<Unit> units;
    private int troopNumber;

    public Troop(int number) {
        this.units = new ArrayList<Unit>();
        this.troopNumber = number;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public String getTroopNumber() {
        return "[" + Integer.toString(troopNumber) + "]";
    }

    public void addAlly(Unit unit) {
        unit.setName(getTroopNumber() + unit.getName());
        this.units.add(unit);
    }

    public boolean isAnnihilated() {
        return aliveCount() == 0;
    }

    public int aliveCount() {
       return units.stream().filter(unit -> unit.isAlive()).toArray().length;
    }
}
