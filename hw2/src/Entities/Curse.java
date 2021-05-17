package Entities;

import java.util.List;
import java.util.ArrayList;

public class Curse {
    private List<Unit> cursers;
    
    public Curse() {
        cursers = new ArrayList<Unit>();
    }

    public void addCurser(Unit curser) {
        if (!cursers.contains(curser)) {
            cursers.add(curser);
        }
    }

    public void curseEffect(Unit dyingUnit) {
        for (Unit curser : cursers) {
            if (curser.isAlive()) {
                curser.increaseHp(dyingUnit.getMp());
            }
        }
    }
}
