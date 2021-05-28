package Utils;

import java.util.List;
import java.util.ArrayList;
import Entities.Troop;
import Skills.BasicAttack;
import Skills.Skill;
import Units.UnitFactory;
import Units.Unit;
import Units.ManualUnit;

public final class Utils {
    private static Unit getUnit(List<Skill> allowedSkills, UnitFactory factory) {
        List<String> unitInfo = Reader.readUnit();

        if (unitInfo == null) {
            return null;
        }

        String name = unitInfo.get(0);
        int hp = Integer.parseInt(unitInfo.get(1));
        int mp = Integer.parseInt(unitInfo.get(2));
        int strength = Integer.parseInt(unitInfo.get(3));
        List<Skill> skills = new ArrayList<Skill>();

        skills.add(new BasicAttack());

        for (int i = 4; i < unitInfo.size(); ++i) {
            String skillName = unitInfo.get(i);
            for (Skill skill : allowedSkills) {
                if (skill.toString().equals(skillName)) {
                    skills.add(skill.create());
                    break;
                }
            }
        }
        
        if (name.equals("Hero")) {
            return new ManualUnit(hp, mp, strength, name, skills);
        } else {
            return factory.create(hp, mp, strength, name, skills);
        }
    }

    public static Troop getTroop(List<Skill> allowedSkills, int number, UnitFactory factory) {
        Troop troop = new Troop(number);

        while (true) {
            Unit unit = getUnit(allowedSkills, factory);

            if (unit == null) {
                break;
            }

            troop.addAlly(unit);
        }

        return troop;
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

    public static List<Integer> getAvailableSkills(Unit unit) {
        List<Integer> indices = new ArrayList<Integer>();

        for (int i = 0; i < unit.getSkills().size(); i++) {
            Skill skill = unit.getSkills().get(i);
            if (skill.available(unit)) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static List<String> getTargetUnitsName(List<Unit> units) {
        List<String> names = new ArrayList<String>();

        for (Unit unit : units) {
            names.add(unit.getName());
        }

        return names;
    }
}
