/**
 * The big-2 game will be started from the Main class.
 */

import Entity.Game;
import Pattern.Factory.*;

public class Main {
    public static void main(String[] args) {
        PatternFactory patternFactory = new PatternFactory();

        // Define the patterns allowed in a game
        patternFactory.register(new SingleFactory());
        patternFactory.register(new PairFactory());
        patternFactory.register(new StraightFactory());
        patternFactory.register(new FullHouseFactory());

        Game bigTwo = new Game(patternFactory);
        bigTwo.start();
    }
}
