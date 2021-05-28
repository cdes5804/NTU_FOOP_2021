package Entities;

public class RPG {
    Troop troopOne;
    Troop troopTwo;
    
    public RPG(Troop troopOne, Troop troopTwo) {
        this.troopOne = troopOne;
        this.troopTwo = troopTwo;
    }

    public void start() {
        while (!isGameOver()) {
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
        return troopOne.getUnits().get(0).isAlive();
    }

    private boolean isGameOver() {
        return troopTwo.isAnnihilated() || !troopOne.getUnits().get(0).isAlive();
    }
}
