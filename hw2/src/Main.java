/**
 * The RPG game will be started from the Main class.
 */
import java.util.List;
import java.util.ArrayList;
import Skills.*;
import Units.UnitFactory;
import Units.AIUnitFactory;
import Entities.RPG;
import Entities.Troop;
import Utils.Utils;
import tw.waterball.foop.hw2.provided.AI;

public class Main {
    public static void main(String[] args) {
        AI ai = new AI();
        List<Skill> allowedSkills = new ArrayList<Skill>();
        UnitFactory factory = new AIUnitFactory(ai);

        allowedSkills.add(new WaterBall());
        allowedSkills.add(new FireBall());
        allowedSkills.add(new SelfHealing());
        allowedSkills.add(new Petrochemical());
        allowedSkills.add(new Poison());
        allowedSkills.add(new Summon(factory));
        allowedSkills.add(new SelfExplosion());
        allowedSkills.add(new Cheerup());
        allowedSkills.add(new Curse());
        allowedSkills.add(new Punch());

        Troop troopOne = Utils.getTroop(allowedSkills, 1, factory);
        Troop troopTwo = Utils.getTroop(allowedSkills, 2, factory);

        RPG game = new RPG(troopOne, troopTwo);
        game.start();
    }
}
