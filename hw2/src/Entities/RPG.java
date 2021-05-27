package Entities;

import java.util.List;
import Skills.Skill;
import Units.UnitFactory;
import Utils.Utils;

public class RPG {
    Troop troopOne;
    Troop troopTwo;
    
    public RPG(List<Skill> allowedSkills, UnitFactory factory) {
        troopOne = Utils.getTroop(allowedSkills, "[1]", factory);
        troopTwo = Utils.getTroop(allowedSkills, "[2]", factory);
    }

    public void start() {
        while (isTroopAlive()) {
            Round round = new Round(troopOne, troopTwo);
            round.start();
        }

        if (isVictory()) {
            System.out.println("You win.");
        } else {
            System.out.println("You lose.");
        }
    }

    private boolean isVictory()  {
        return !troopOne.isAnnihilated();
    }

    private boolean isTroopAlive() {
        return !troopOne.isAnnihilated() && !troopTwo.isAnnihilated();
    }
}
