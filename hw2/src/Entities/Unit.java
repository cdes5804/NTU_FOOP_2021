package Entities;

import java.util.List;
import java.util.ArrayList;
import Skills.SkillBase;
import States.StateBase;
import States.Normal;
import Utils.Utils;
import Utils.Writer;
import tw.waterball.foop.hw2.provided.Target;
import tw.waterball.foop.hw2.provided.AI;

public class Unit implements Target {
    private int healthPoint;
    private int magicPoint;
    private int strength;
    private String name;
    private List<SkillBase> skills;
    private StateBase state;
    private boolean isPetrified;
    private boolean isCheeredUp;
    private List<Unit> curse;
    private int onePunchDamage;
    private AI ai;

    public Unit(int healthPoint, int magicPoint, int strength, String name, List<SkillBase> skills, AI ai) {
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.strength = strength;
        this.name = name;
        this.skills = skills;
        this.state = new Normal(this);
        this.isPetrified = false;
        this.isCheeredUp = false;
        this.curse = new ArrayList<Unit>();
        this.ai = ai;
        onePunchDamage = 0;
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

    public void setCheeredUp(boolean isCheeredUp) {
        this.isCheeredUp = isCheeredUp;
    }

    public boolean isCheeredUp() {
        return isCheeredUp;
    }

    public void setPetrified(boolean isPetrified) {
        this.isPetrified = isPetrified;
    }

    public boolean isPetrified() {
        return isPetrified;
    }

    public void setState(StateBase state) {
        this.state.clearState();
        this.state = state;
    }

    public StateBase getState() {
        return state;
    }

    public int getOnePunchDamage() {
        return onePunchDamage;
    }

    public void addCurse(Unit curser) {
        if (!curse.contains(curser)) {
            curse.add(curser);
        }
    }

    private void die() {
        for (Unit curser : curse) {
            curser.increaseHp(magicPoint);
        }
        Writer.writeDies(this);
    }

    /* Change the functions purpose to record how much damage OnePunch is going to cause the enemy */
    @Override
    public void takeOnePunchDamage(int damage) {
        onePunchDamage = damage;
    }
}
