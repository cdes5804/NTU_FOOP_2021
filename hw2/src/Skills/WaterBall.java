package Skills;

public class WaterBall extends SkillBase implements Actions {
    public WaterBall() {
        super(50, 1, 120, 1);
    }

    @Override
    public void perform(Unit activeUnit, Troop activeTroop, Troop oppositeTroop) {
        activeUnit.decreaseMp(requiredMp);
        
        int totalDamage = damage + activeUnit.isCheeredUp() ? 50 : 0;

        List<Integer> indices = new ArrayList<Integer>(1, 2, 3);
        for (int index : indices) {
            oppositeTroop.units[index].decreaseHp(totalDamage);
        }
    }
}
