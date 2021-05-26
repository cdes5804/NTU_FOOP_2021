package Units;

import java.util.List;
import java.util.ArrayList;
import Utils.Writer;
import Utils.Reader;
import Utils.Utils;
import Skills.SkillBase;

public class ManualUnit extends Unit {
    public ManualUnit(int healthPoint, int magicPoint, int strength, String name, List<SkillBase> skills) {
        super(healthPoint, magicPoint, strength, name, skills);
    }

    @Override
    public SkillBase selectAction() {
        SkillBase skill = null;

        while (skill == null || !skill.available(this)) {
            if (skill != null) {
                Writer.writeUnavailableSkill();
            }
            Writer.writeSkills(skills);
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
            Writer.writeTargets(numTarget, availableUnits);

            List<Integer> indices = Reader.readTarget();
            for (int index : indices) {
                targets.add(availableUnits.get(index));
            }
        }
        
        return targets;
    }
}
