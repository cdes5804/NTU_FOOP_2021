package Entities;

import java.util.List;


import java.util.ArrayList;
import Skills.SkillBase;
import States.StateBase;
import Effects.EffectBase;
import States.Normal;
import Utils.Utils;
import Utils.Writer;
import tw.waterball.foop.hw2.provided.AI;

public class Unit {
    private int healthPoint;
    private int magicPoint;
    private int strength;
    private String name;
    private List<SkillBase> skills;
    private StateBase state;
    private boolean canMove;
    private int bonusDamage;
    private List<EffectBase> deathEffect;
    private AI ai;

    public Unit(int healthPoint, int magicPoint, int strength, String name, List<SkillBase> skills, AI ai) {
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.strength = strength;
        this.name = name;
        this.skills = skills;
        this.state = new Normal(this);
        this.canMove = true;
        this.bonusDamage = 0;
        this.deathEffect = new ArrayList<EffectBase>();
        this.ai = ai;
    }

    public boolean isAlive() {
        return healthPoint > 0;
    }

    public void action(Troop activeTroop, Troop oppositeTroop) {
        SkillBase skill = Utils.getAction(this);
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

    public boolean isAI() {
        return ai != null && !name.equals("[1]Hero");
    }

    public AI getAI() {
        return ai;
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
