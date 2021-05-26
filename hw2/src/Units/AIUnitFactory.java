package Units;

import java.util.List;
import Skills.SkillBase;
import tw.waterball.foop.hw2.provided.AI;

public class AIUnitFactory extends UnitFactory {
    private AI ai;

    public AIUnitFactory(AI ai) {
        this.ai = ai;
    }

    @Override
    public Unit create(int healthPoint, int magicPoint, int strength, String name, List<SkillBase> skills) {
        return new AIUnit(healthPoint, magicPoint, strength, name, skills, ai);
    }
}
