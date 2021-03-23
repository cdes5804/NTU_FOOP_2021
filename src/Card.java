/**
 * A card in Poker
 */

public class Card {
    enum Rank {
        TREY,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE,
        DEUCE
    }

    enum Suit {
        CLUB,
        DIAMOND,
        HEART,
        SPADE
    }

    private Rank rank;
    private Suit suit;

    public Card(String cardString) {
        switch (cardString.charAt(0)) {
            case 'C':
                suit = Suit.CLUB;
                break;
            case 'D':
                suit = Suit.DIAMOND;
                break;
            case 'H':
                suit = Suit.HEART;
                break;
            case 'S':
                suit = Suit.SPADE;
                break;
            default:
                throw new IllegalArgumentException("Invalid suit");
        }

        switch (cardString.substring(2, cardString.length())) {
            case "3":
                rank = Rank.TREY;
                break;
            case "4":
                rank = Rank.FOUR;
                break;
            case "5":
                rank = Rank.FIVE;
                break;
            case "6":
                rank = Rank.SIX;
                break;
            case "7":
                rank = Rank.
        }
    }
}
