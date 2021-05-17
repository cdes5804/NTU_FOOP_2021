package Utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;
import Entities.Troop;
import Entities.Unit;
import Skills.BasicAttack;
import Skills.SkillBase;
import tw.waterball.foop.hw2.provided.AI;

public final class Utils {
    private static Unit getUnit(List<SkillBase> allowedSkills, String prefix, AI ai) {
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

        //AI newAI = (ai == null ? null : new AI());
        return new Unit(hp, mp, strength, name, skills, ai);
    }

    public static Troop getTroop(List<SkillBase> allowedSkills, String prefix, AI ai) {
        List<Unit> units = new ArrayList<Unit>();

        while (true) {
            Unit unit = getUnit(allowedSkills, prefix, ai);

            if (unit == null) {
                break;
            }

            units.add(unit);
        }

        return new Troop(units);
    }

    private static int countAvailableSkills(Unit unit) {
        return unit.getSkills().stream().filter(skill -> skill.available(unit)).toArray().length;
    }

    private static int getAvailableSkillOrderInAllSkills(Unit unit, int availableCount) {
        int counter = 0;
        for (int i = 0; i < unit.getSkills().size(); ++i) {
            SkillBase skill = unit.getSkills().get(i);

            if (skill.available(unit)) {
                counter++;
            }

            if (counter == availableCount + 1) {
                return i;
            }
        }

        return 0; // should not happen
    }

    private static int getActionFromUserOrAI(Unit activeUnit) {
        int action = 0;
        Writer.writeSkills(activeUnit.getSkills());

        if (activeUnit.isAI()) {
            int availableSkillCount = countAvailableSkills(activeUnit);
            List<Integer> actions = IntStream.range(0, availableSkillCount).boxed().collect(Collectors.toList());
            int availableCount = activeUnit.getAI().selectAction(actions);
            action = getAvailableSkillOrderInAllSkills(activeUnit, availableCount);
        } else {
            action = Reader.readAction();
        }

        return action;
    }

    public static SkillBase getAction(Unit activeUnit) {
        SkillBase skill = null;

        while (skill == null || !skill.available(activeUnit)) {
            if (skill != null) {
                Writer.writeUnavailableSkill();
            }
            int action = getActionFromUserOrAI(activeUnit);
            skill = activeUnit.getSkills().get(action);
        }

        return skill;
    }

    public static List<Integer> getTargets(Unit activeUnit, int numTarget, Troop troop) {
        List<Integer> target = new ArrayList<Integer>();

        if (troop.aliveCount() <= numTarget) {
            for (int i = 0; i < troop.getUnits().size(); ++i) {
                Unit unit = troop.getUnits().get(i);
                if (unit.isAlive()) {
                    target.add(i);
                }
            }
        } else {
            if (activeUnit.isAI()) {
                target = activeUnit.getAI().selectTarget(troop.aliveCount(), numTarget);
            } else {
                Writer.writeTargets(numTarget, troop);
                target = Reader.readTarget();
            }
        }

        return target;
    }

    public static List<String> getTargetUnitsName(List<Unit> units, List<Integer> targets) {
        List<String> names = new ArrayList<String>();

        if (targets == null) {
            for (Unit unit : units) {
                names.add(unit.getName());
            }
        } else {
            for (int index : targets) {
                names.add(units.get(index).getName());
            }
        }

        return names;
    }
}
