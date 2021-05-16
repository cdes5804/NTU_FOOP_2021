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
    private static Unit getUnit(List<SkillBase> allowedSkills, String prefix) {
        List<String> unitInfo = Reader.readUnit();

        if (unitInfo == null) {
            return null;
        }

        String name = prefix + unitInfo.get(0);
        int hp = Integer.parseInt(unitInfo.get(1));
        int mp = Integer.parseInt(unitInfo.get(2));
        int strength = Integer.parseInt(unitInfo.get(3));
        List<SkillBase> skills = Arrays.asList(new BasicAttack());

        for (int i = 4; i < unitInfo.size(); ++i) {
            String skillName = unitInfo.get(i);
            for (SkillBase skill : allowedSkills) {
                if (skill.toString() == skillName) {
                    skills.add(skill.create());
                    break;
                }
            }
        }

        return new Unit(hp, mp, strength, name, skills);
    }

    public static Troop getTroop(List<SkillBase> allowedSkills, String prefix) {
        List<Unit> units = new ArrayList<Unit>();

        while (true) {
            Unit unit = getUnit(allowedSkills, prefix);

            if (unit == null) {
                break;
            }

            units.add(unit);
        }

        return new Troop(units);
    }

    public static int getAction(Unit activeUnit, AI ai) {
        int action = 0;

        if (activeUnit.getName() != "Hero" && ai != null) {
            int[] actions = IntStream.range(0, activeUnit.getSkills().size()).toArray();
            action = ai.selectAction(Arrays.asList(actions));
        } else {
            Writer.writeSkills(activeUnit.getSkills());
            action = Reader.readAction();
        }
    }

    public static List<Integer> getTarget(Unit activeUnit, int numTarget, Troop troop, AI ai) {
        List<Integer> target;

        if (troop.aliveCount() <= numTarget) {
            for (int i = 0; i < troop.getUnits().size(); ++i) {
                Unit unit = troop.getUnits().get(i);
                if (unit.isAlive()) {
                    target.add(i);
                }
            }
        } else {
            if (activeUnit.getName() != "Hero" && ai != null) {
                target = ai.selectTarget(troop.aliveCount(), numTarget);
            } else {
                Writer.writeTargets(numTarget, troop);
                target = Reader.readTarget();
            }
        }

        return target;
    }
}
