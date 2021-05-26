package Units;

import java.util.List;
import Skills.SkillBase;

public interface Action {
    public SkillBase selectAction();
    public List<Unit> selectTargets(int numTarget, List<Unit> candidates);
}
