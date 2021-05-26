package Units;

import java.util.List;
import java.util.ArrayList;
import Utils.Utils;
import Utils.Writer;
import Skills.SkillBase;
import tw.waterball.foop.hw2.provided.AI;

public class AIUnit extends Unit {
    private AI ai;

    public AIUnit(int healthPoint, int magicPoint, int strength, String name, List<SkillBase> skills, AI ai) {
        super(healthPoint, magicPoint, strength, name, skills);
        this.ai = ai;
    }

    @Override
    public SkillBase selectAction() {
        Writer.writeSkills(skills);
        List<Integer> indices = Utils.getAvailableSkills(this);
        int index = ai.selectAction(indices);
        return skills.get(index);
    }

    @Override
    public List<Unit> selectTargets(int numTarget, List<Unit> candidates) {
        List<Unit> targets = new ArrayList<Unit>();

        List<Unit> availableUnits = Utils.getAvailableTargets(this, candidates);
        if (availableUnits.size() <= numTarget) {
            targets.addAll(availableUnits);
        } else {
            List<Integer> indices = ai.selectTarget(availableUnits.size(), numTarget);
            for (int index : indices) {
                targets.add(availableUnits.get(index));
            }
        }
        
        return targets;
    }
}
