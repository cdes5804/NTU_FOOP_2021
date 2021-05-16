package Entities;

import java.util.List;
import java.util.Arrays;
import Utils.Utils;
import Skills.SkillBase;
import Utils.Writer;
import tw.waterball.foop.hw2.provided.AI;

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
        return aliveCount() == 0;
    }

    public int aliveCount() {
       return units.size();
    }

    public void removeDeath() {
        Unit alive[] = units.stream().filter(unit -> unit.isAlive()).toArray(Unit[]::new);
        units = Arrays.asList(alive);
    }

    public void action(AI ai, Troop oppositeTroop) {
        for (Unit unit : units) {
            if (!unit.isAlive()) {
                continue;
            }

            Writer.writeTurn(unit);

            if (!unit.isPetrified()) {
                SkillBase skill = null;

                while (skill == null || !skill.available(unit)) {
                    if (skill != null) {
                        Writer.writeUnavailableSkill();
                    }
                    int action = unit.selectAction(ai);
                    skill = unit.getSkills().get(action);
                }
                
                skill.perform(ai);
            }
        }
    }
}
