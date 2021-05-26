/**
 * The RPG game will be started from the Main class.
 */
import java.util.List;
import java.util.ArrayList;
import Skills.*;
import Units.AIUnitFactory;
import Entities.RPG;
import tw.waterball.foop.hw2.provided.AI;

public class Main {
    public static void main(String[] args) {
        AI ai = new AI();
        List<SkillBase> allowedSkills = new ArrayList<SkillBase>();
        AIUnitFactory factory = new AIUnitFactory(ai);

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

        RPG game = new RPG(allowedSkills, factory);
        game.start();
    }
}
