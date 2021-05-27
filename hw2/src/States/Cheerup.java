package States;

import Units.Unit;
import Skills.Skill;

public class Cheerup extends StateBase {
    public Cheerup(Unit target) {
        super(target);
    }

    @Override
    public void takeEffect() {
        for (Skill skill : target.getSkills()) {
            skill.setDamageDelta(50);
        }
    }

    @Override
    public void clearState() {
        for (Skill skill : target.getSkills()) {
            skill.setDamageDelta(0);
        }
    }

    @Override
    public String toString() {
        return "Cheerup";
    }
}
