/**
 * The big-2 game will be started from the Main class.
 */

import Entity.Game;
import Pattern.PatternFactory;
import Pattern.Single;
import Pattern.Pair;
import Pattern.Straight;
import Pattern.FullHouse;

public class Main {
    public static void main(String[] args) {
        PatternFactory patternFactory = new PatternFactory();

        // Define the patterns allowed in a game
        patternFactory.register(new Single());
        patternFactory.register(new Pair());
        patternFactory.register(new Straight());
        patternFactory.register(new FullHouse());

        Game bigTwo = new Game(patternFactory);
        bigTwo.start();
    }
}
