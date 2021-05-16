package Entities;

import tw.waterball.foop.hw2.provided.AI;

public class Round {
    Troop troopOne;
    Troop troopTwo;
    AI ai;

    public Round(Troop troopOne, Troop troopTwo, AI ai) {
        this.troopOne = troopOne;
        this.troopTwo = troopTwo;
        this.ai = ai;
    }

    public void start() {
        troopOne.action(ai, troopTwo);
        troopTwo.action(ai, troopOne);
    }
}
