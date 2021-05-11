package IO;

import Entity.Player;
import Entity.Card;
import Pattern.PatternBase;
import java.util.List;

/**
 * Writer is responsible for every output.
 */
public class Writer {
    public static void writeRoundBegin() {
        System.out.println("New round begins.");
    }

    public static void writePlayerTurn(Player player) {
        System.out.printf("Next turn: %s\n", player.name);
    }

    public static void writePlayerHandCards(List<Card> handCards) {
        StringBuilder numbers = new StringBuilder();
        StringBuilder cards = new StringBuilder();

        for (int i = 0; i < handCards.size(); ++i) {
            String cardString = handCards.get(i).toString();
            numbers.append(String.format("%"+(-cardString.length())+"s", i)).append(" ");
            cards.append(cardString).append(" ");
        }

        System.out.println(numbers.toString().stripTrailing());
        System.out.println(cards.toString().stripTrailing());
    }

    public static void writeValidPlay(Player player, PatternBase pattern) throws IllegalAccessError {
        String patternName = "";
        StringBuilder playString = new StringBuilder();
        switch (pattern.getClass().getSimpleName()) {
            case "Single":
                patternName = "single";
                break;
            case "Pair":
                patternName = "pair";
                break;
            case "Straight":
                patternName = "straight";
                break;
            case "FullHouse":
                patternName = "full house";
                break;
            default:
                throw new IllegalArgumentException("Invalid Class");
        }

        playString.append(String.format("Player %s plays a %s ", player.name, patternName));
        for (Card card : pattern.cards) {
            playString.append(card.toString()).append(" ");
        }

        System.out.println(playString.toString().stripTrailing() + ".");
    }

    public static void writeInvalidPlay() {
        System.out.println("Invalid play, please try again.");
    }

    public static void writePlayerPass(Player player) {
        System.out.printf("Player %s passes.\n", player.name);
    }

    public static void writeInvalidPass() {
        System.out.println("You can't pass in the new round.");
    }

    public static void writeWinner(Player player) {
        System.out.printf("Game over, the winner is %s.\n", player.name);
    }
}
