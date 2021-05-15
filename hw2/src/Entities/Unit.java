package Entities;

import java.util.List;

public class Unit {
    private int healthPoint;
    private int magicPoint;
    private int strength;
    private String name;

    public Unit(int healthPoint, int magicPoint, int strength, String name) {
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.strength = strength;
        this.name = name;
    }

    public boolean isAlive() {
        return heathPoint > 0;
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

    public int getMP() {
        return magicPoint;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isCheeredUp() {
        return false;
    }

    private void die() {
        
    }
}
