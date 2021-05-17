package Entities;

import java.util.List;
import Skills.SkillBase;
import Utils.Utils;
import Utils.Writer;
import tw.waterball.foop.hw2.provided.AI;

public class RPG {
    Troop troopOne;
    Troop troopTwo;
    AI ai;

    public RPG(AI ai, List<SkillBase> allowedSkills) {
        troopOne = Utils.getTroop(allowedSkills, "[1]", ai);
        troopTwo = Utils.getTroop(allowedSkills, "[2]", ai);
        this.ai = ai;
    }

    public void start() {
        while (isHeroAlive() && isTroopAlive()) {
            Round round = new Round(troopOne, troopTwo);
            round.start();
        }

        if (isVictory()) {
            Writer.writeWin();
        } else {
            Writer.writeLose();
        }
    }

    private boolean isVictory()  {
        return !troopOne.isAnnihilated();
    }

    private boolean isHeroAlive() {
        return troopOne.getUnits().get(0).isAlive();
    }

    private boolean isTroopAlive() {
        return !troopOne.isAnnihilated() && !troopTwo.isAnnihilated();
    }
}
