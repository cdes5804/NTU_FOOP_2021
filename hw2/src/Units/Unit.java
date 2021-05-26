package Units;

import java.util.List;


import java.util.ArrayList;
import Skills.SkillBase;
import States.StateBase;
import Effects.EffectBase;
import Entities.Troop;
import States.Normal;
import Utils.Writer;

public abstract class Unit implements Action {
    protected int healthPoint;
    protected int magicPoint;
    protected int strength;
    protected String name;
    protected List<SkillBase> skills;
    protected StateBase state;
    protected boolean canMove;
    protected int bonusDamage;
    protected List<EffectBase> deathEffect;

    public Unit(int healthPoint, int magicPoint, int strength, String name, List<SkillBase> skills) {
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.strength = strength;
        this.name = name;
        this.skills = skills;
        this.state = new Normal(this);
        this.canMove = true;
        this.bonusDamage = 0;
        this.deathEffect = new ArrayList<EffectBase>();
    }

    public boolean isAlive() {
        return healthPoint > 0;
    }

    public void action(Troop activeTroop, Troop oppositeTroop) {
        SkillBase skill = selectAction();
        skill.perform(this, activeTroop, oppositeTroop);
    }

    public void decreaseHp(int amount) {
        healthPoint -= amount;
        if (!isAlive()) {
            die();
        }
    }

    public void increaseHp(int amount) {
        healthPoint += amount;
    }

    public void decreaseMp(int amount) {
        magicPoint -= amount;
    }

    public int getHp() {
        return healthPoint;
    }

    public int getMp() {
        return magicPoint;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public List<SkillBase> getSkills() {
        return skills;
    }

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    public int getBonusDamage() {
        return bonusDamage;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean canMove() {
        return canMove;
    }

    public void setState(StateBase state) {
        this.state.clearState();
        this.state = state;
    }

    public StateBase getState() {
        return state;
    }

    public List<EffectBase> getDeathEffect() {
        return deathEffect;
    }

    public void addDeathEffect(EffectBase effect) {
        deathEffect.add(effect);
    }

    private void die() {
        Writer.writeDies(this);
        
        for (EffectBase effect : deathEffect) {
            effect.trigger();
        }
    }
}
