package Entities;

import java.util.List;

public class Troop {
    public List<Unit> units;

    public Troop(List<Unit> units) {
        this.units = units;
    }

    public void addAlly(Unit unit) {
        this.units.add(unit);
    }
}
