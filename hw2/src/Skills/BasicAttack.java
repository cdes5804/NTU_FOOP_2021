package Skills;

public class BasicAttack extends SkillBase implements Action {
    public BasicAttack() {
        super(0, 1, 0, 0);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        int totalDamage = damage + activeUnit.isCheeredUp() ? 50 : 0;

        List<Integer> indices = new ArrayList<Integer>(1, 2, 3);
        for (int index : indices) {
            oppositeTroop.units[index].decreaseHp(totalDamage);
        }
    }
}