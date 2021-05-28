package Units;

import java.util.List;
import Skills.Skill;

public interface Action {
    public Skill selectAction();
    public List<Unit> selectTargets(int numTarget, List<Unit> candidates);
}
