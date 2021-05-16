package Entities;

import java.util.List;

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

    public Unit(int healthPoint, int magicPoint, int strength, String name, List<SkillBase> skills) {
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.strength = strength;
        this.name = name;
        this.skills = skills;
        this.state = new Normal(this);
        this.isPetrified = false;
        this.isCheeredUp = false;
    }

    public int selectAction(AI ai) {
        return Utils.getAction(this, ai);
    }

    public boolean isAlive() {
        return healthPoint > 0;
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

    public void updateState() {
        state.decreaseRemainingRound();
        if (state.isOver()) {
            state.clearState();
            state = new Normal(this);
        }
    }

    public String getState() {
        return state.toString();
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

    @Override
    public void takeOnePunchDamage(int damage) {
        decreaseHp(damage);
    }
}
