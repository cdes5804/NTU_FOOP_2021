package Units;

import java.util.List;
import java.util.ArrayList;
import Utils.Reader;
import Utils.Utils;
import Skills.Skill;

public class ManualUnit extends Unit {
    public ManualUnit(int healthPoint, int magicPoint, int strength, String name, List<Skill> skills) {
        super(healthPoint, magicPoint, strength, name, skills);
    }

    @Override
    public Skill selectAction() {
        Skill skill = null;

        while (skill == null || !skill.available(this)) {
            if (skill != null) {
                System.out.println("You can't perform the action: insufficient MP.");
            }

            StringBuilder builder = new StringBuilder();
            builder.append("Select an action:");
            
            for (int i = 0; i < skills.size(); ++i) {
                builder.append(String.format(" (%d) ", i));
                builder.append(skills.get(i).toString());
            }

            System.out.println(builder.toString().stripTrailing());

            int action = Reader.readAction();
            skill = skills.get(action);
        }

        return skill;
    }

    @Override
    public List<Unit> selectTargets(int numTarget, List<Unit> candidates) {
        List<Unit> targets = new ArrayList<Unit>();

        List<Unit> availableUnits = Utils.getAvailableTargets(this, candidates);

        if (availableUnits.size() <= numTarget) {
            targets.addAll(availableUnits);
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("Select %d targets:", numTarget));
            
            for (int i = 0; i < availableUnits.size(); ++i) {
                builder.append(String.format(" (%d) ", i));
                builder.append(availableUnits.get(i).getName());
            }

            System.out.println(builder.toString().stripTrailing());

            List<Integer> indices = Reader.readTarget();
            for (int index : indices) {
                targets.add(availableUnits.get(index));
            }
        }
        
        return targets;
    }
}
