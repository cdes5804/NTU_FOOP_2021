package Entities;

import java.util.List;
import Skills.SkillBase;
import Units.AIUnitFactory;
import Utils.Utils;
import Utils.Writer;

public class RPG {
    Troop troopOne;
    Troop troopTwo;
    
    public RPG(List<SkillBase> allowedSkills, AIUnitFactory factory) {
        troopOne = Utils.getTroop(allowedSkills, "[1]", factory);
        troopTwo = Utils.getTroop(allowedSkills, "[2]", factory);
    }

    public void start() {
        while (isTroopAlive()) {
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

    private boolean isTroopAlive() {
        return !troopOne.isAnnihilated() && !troopTwo.isAnnihilated();
    }
}
