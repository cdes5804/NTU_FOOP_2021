package Utils;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Skills.BasicAttack;
import Skills.SkillBase;
import Units.UnitFactory;
import Units.Unit;
import Units.ManualUnit;

public final class Utils {
    private static Unit getUnit(List<SkillBase> allowedSkills, String prefix, UnitFactory factory) {
        List<String> unitInfo = Reader.readUnit();

        if (unitInfo == null) {
            return null;
        }

        String name = prefix + unitInfo.get(0);
        int hp = Integer.parseInt(unitInfo.get(1));
        int mp = Integer.parseInt(unitInfo.get(2));
        int strength = Integer.parseInt(unitInfo.get(3));
        List<SkillBase> skills = new ArrayList<SkillBase>();

        skills.add(new BasicAttack());

        for (int i = 4; i < unitInfo.size(); ++i) {
            String skillName = unitInfo.get(i);
            for (SkillBase skill : allowedSkills) {
                if (skill.toString().equals(skillName)) {
                    skills.add(skill.create());
                    break;
                }
            }
        }
        
        if (name.equals("[1]Hero")) {
            return new ManualUnit(hp, mp, strength, name, skills);
        } else {
            return factory.create(hp, mp, strength, name, skills);
        }
    }

    public static Troop getTroop(List<SkillBase> allowedSkills, String prefix, UnitFactory factory) {
        List<Unit> units = new ArrayList<Unit>();

        while (true) {
            Unit unit = getUnit(allowedSkills, prefix, factory);

            if (unit == null) {
                break;
            }

            units.add(unit);
        }

        return new Troop(units);
    }

    public static List<Integer> getAvailableSkills(Unit unit) {
        List<Integer> indices = new ArrayList<Integer>();

        for (int i = 0; i < unit.getSkills().size(); i++) {
            SkillBase skill = unit.getSkills().get(i);
            if (skill.available(unit)) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static List<Unit> getAvailableTargets(Unit activeUnit, List<Unit> units) {
        List<Unit> availableUnits = new ArrayList<Unit>();

        for (Unit unit : units) {
            if (unit.isAlive() && unit != activeUnit) {
                availableUnits.add(unit);
            }
        }

        return availableUnits;
    }

    public static String getPrefix(Unit unit) {
        return unit.getName().substring(0, 3);
    }

    public static List<String> getTargetUnitsName(List<Unit> units) {
        List<String> names = new ArrayList<String>();

        for (Unit unit : units) {
            names.add(unit.getName());
        }

        return names;
    }
}
