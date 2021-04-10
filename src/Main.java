import Entity.Game;
import Entity.Card;
import Pattern.Factory.*;

/**
 * The big-2 game will be started from the Main class.
 */
public class Main {
    public static void main(String[] args) {
        PatternFactory patternFactory = new PatternFactory();

        // Define the patterns allowed in a game.
        patternFactory.register(new SingleFactory());
        patternFactory.register(new PairFactory());
        patternFactory.register(new StraightFactory());
        patternFactory.register(new FullHouseFactory());

        // Define the starting card.
        Card startingCard = new Card("C[3]");

        Game bigTwo = new Game(patternFactory, startingCard);
        bigTwo.start();
    }
}
