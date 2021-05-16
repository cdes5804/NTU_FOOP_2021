package Entities;

import java.util.List;
import Skills.SkillBase;
import Utils.Utils;
import tw.waterball.foop.hw2.provided.AI;

public class RPG {
    Troop troopOne;
    Troop troopTwo;
    AI ai;

    public RPG(AI ai, List<SkillBase> allowedSkills) {
        troopOne = Utils.getTroop(allowedSkills, "[1]");
        troopTwo = Utils.getTroop(allowedSkills, "[2]");
        this.ai = ai;
    }

    public void start() {
        while (isHeroAlive() && isTroopAlive()) {
            Round round = new Round(troopOne, troopTwo, ai);
            round.start();
        }
    }

    private boolean isHeroAlive() {
        return troopOne.getUnits().get(0).isAlive();
    }

    private boolean isTroopAlive() {
        return !troopOne.isAnnihilated() && troopTwo.isAnnihilated();
    }
}
