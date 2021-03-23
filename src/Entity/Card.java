package Entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

/**
 * A card in Poker
 */
public class Card {
    public static enum Rank {
        THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
        SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
        JACK("J"), QUEEN("Q"), KING("K"), ACE("A"),
        DEUCE("2");

        private final String _rankString;
        private static final List<Rank> values = 
            Collections.unmodifiableList(Arrays.asList(values()));

        private Rank(String rankString) {
            _rankString = rankString;
        }

        private String getRankString() {
            return _rankString;
        }

        public static final Rank getRankFromString(String rankString) throws IllegalArgumentException {
            for (Rank rank : Rank.values) {
                if (rank.getRankString().equals(rankString)) {
                    return rank;
                }
            }
            throw new IllegalArgumentException("Invalid Rank");
        }
    }

    public static enum Suit {
        CLUB("C"), DIAMOND("D"), HEART("H"), SPADE("S");

        private final String _suitString;
        private static final List<Suit> values = 
            Collections.unmodifiableList(Arrays.asList(values()));
        
        private Suit(String suitString) {
            _suitString = suitString;
        }

        private String getSuitString() {
            return _suitString;
        }

        public static final Suit getSuitFromString(String suitString) throws IllegalArgumentException {
            for (Suit suit : Suit.values) {
                if (suit.getSuitString().equals(suitString)) {
                    return suit;
                }
            }
            throw new IllegalArgumentException("Invalid Suit");
        }
    }

    private final Rank _rank;
    private final Suit _suit;

    public Card(String cardString) {
        String suit = cardString.substring(0, 1);
        _suit = Suit.getSuitFromString(suit);
        String rank = cardString.substring(2, cardString.length() - 1);
        _rank = Rank.getRankFromString(rank);
    }

    public Suit getSuit() {
        return _suit;
    }

    public Rank getRank() {
        return _rank;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Card)) { 
            return false; 
        }

        return new Card.CardComparator().compare(this, (Card)o) == 0;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", _suit.getSuitString(), _rank.getRankString());
    }

    public static class CardComparator implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            if (card1._rank != card2._rank) {
                return card1._rank.compareTo(card2._rank);
            } else if (card1._suit != card2._suit) {
                return card1._suit.compareTo(card2._suit);
            }
            return 0;
        }
    }
}
