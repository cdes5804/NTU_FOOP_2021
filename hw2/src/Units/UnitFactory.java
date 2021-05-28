package Units;

import java.util.List;
import Skills.Skill;

public abstract class UnitFactory {
    public abstract Unit create(int healthPoint, int magicPoint, int strength, String name, List<Skill> skills);
}
