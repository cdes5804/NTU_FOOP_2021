package Utils;

import java.util.List;
import Skills.SkillBase;
import Units.Unit;

public class Writer {
    public static void writeSkills(List<SkillBase> skills) {
        StringBuilder builder = new StringBuilder();
        builder.append("Select an action:");
        
        for (int i = 0; i < skills.size(); ++i) {
            builder.append(String.format(" (%d) ", i));
            builder.append(skills.get(i).toString());
        }

        System.out.println(builder.toString().stripTrailing());
    }

    public static void writeTargets(int numTarget, List<Unit> units) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Select %d targets:", numTarget));
        
        for (int i = 0; i < units.size(); ++i) {
            builder.append(String.format(" (%d) ", i));
            builder.append(units.get(i).getName());
        }

        System.out.println(builder.toString().stripTrailing());
    }

    public static void writePerformMessage(SkillBase skill, Unit activeUnit, List<Unit> targets) {
        if (skill.toString().equals("Basic Attack")) {
            Unit target = targets.get(0);
            System.out.printf("%s attacks %s.\n", activeUnit.getName(), target.getName());
        } else {
            if (targets == null) {
                System.out.printf("%s uses %s.\n", activeUnit.getName(), skill.toString());
            } else {
                List<String> targetNames = Utils.getTargetUnitsName(targets);
                String message = String.format("%s uses %s on ", activeUnit.getName(), skill.toString())
                                 + String.join(", ", targetNames) + ".";

                System.out.println(message);
            }
        }
    }

    public static void writeDamage(int damage, Unit activeUnit, Unit targetUnit) {
        System.out.printf("%s causes %d damage to %s.\n", activeUnit.getName(), damage, targetUnit.getName());
    }

    public static void writeUnavailableSkill() {
        System.out.println("You can't perform the action: insufficient MP.");
    }

    public static void writeDies(Unit activeUnit) {
        System.out.printf("%s dies.\n", activeUnit.getName());
    }

    public static void writeWin() {
        System.out.println("You win.");
    }

    public static void writeLose() {
        System.out.println("You lose.");
    }

    public static void writeTurn(Unit activeUnit) {
        System.out.printf("%s's turn (HP: %d, MP: %d, STR: %d, State: %s).\n",
                            activeUnit.getName(), activeUnit.getHp(), activeUnit.getMp(),
                            activeUnit.getStrength(), activeUnit.getState().toString());
    }
}
