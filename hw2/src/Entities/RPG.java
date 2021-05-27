package Entities;

public class RPG {
    Troop troopOne;
    Troop troopTwo;
    
    public RPG(Troop troopOne, Troop troopTwo) {
        this.troopOne = troopOne;
        this.troopTwo = troopTwo;
    }

    public void start() {
        while (isTroopAlive()) {
            Round round = new Round(troopOne, troopTwo);
            round.start();
        }

        if (isVictory()) {
            System.out.println("You win.");
        } else {
            System.out.println("You lose.");
        }
    }

    private boolean isVictory()  {
        return !troopOne.isAnnihilated();
    }

    private boolean isTroopAlive() {
        return !troopOne.isAnnihilated() && !troopTwo.isAnnihilated();
    }
}
