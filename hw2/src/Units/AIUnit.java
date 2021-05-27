package Units;

import java.util.List;
import java.util.ArrayList;
import Utils.Utils;
import Skills.Skill;
import tw.waterball.foop.hw2.provided.AI;

public class AIUnit extends Unit {
    private AI ai;

    public AIUnit(int healthPoint, int magicPoint, int strength, String name, List<Skill> skills, AI ai) {
        super(healthPoint, magicPoint, strength, name, skills);
        this.ai = ai;
    }

    @Override
    public Skill selectAction() {
        StringBuilder builder = new StringBuilder();
        builder.append("Select an action:");
        
        for (int i = 0; i < skills.size(); ++i) {
            builder.append(String.format(" (%d) ", i));
            builder.append(skills.get(i).toString());
        }

        System.out.println(builder.toString().stripTrailing());

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
