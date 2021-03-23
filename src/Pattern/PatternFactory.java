package Pattern;

import Entity.Card;
import java.util.List;
import java.util.Collections;

public class PatternFactory {
    public static PatternBase genPattern(List<Card> cards) {
        Collections.sort(cards, new Card.CardComparator());

        if (isSingle(cards)) {
            return new Single(cards);
        } else if (isPair(cards)) {
            return new Pair(cards);
        } else if (isStraight(cards)) {
            return new Straight(cards);
        } else if (isFullHouse(cards)) {
            return new FullHouse(cards);
        }

        return null;
    }

    private static boolean isSingle(List<Card> cards) {
        return cards.size() == 1;
    }

    private static boolean isPair(List<Card> cards) {
        return cards.size() == 2 && isSameRank(cards);
    }

    private static boolean isStraight(List<Card> cards) {
        if (cards.size() != 5) {
            return false;
        }
        if (cards.get(0).getRank().compareTo(cards.get(4).getRank()) == -12) {
            for (int i = 1; i < 5; ++i) {
                if (isContinuous(cards.subList(0, i)) && isContinuous(cards.subList(i, 5))) {
                    return true;
                }
            }
            return false;
        } else {
            return isContinuous(cards);
        }
    }

    private static boolean isFullHouse(List<Card> cards) {
        return cards.size() == 5 && (
            (isSameRank(cards.subList(0, 2)) && isSameRank(cards.subList(2, 5))) ||
            (isSameRank(cards.subList(0, 3)) && isSameRank(cards.subList(3, 5)))
        );
    }

    private static boolean isSameRank(List<Card> cards) {
        int numberOfCards = cards.size();

        for (int i = 0; i < numberOfCards - 1; ++i) {
            if (cards.get(i).getRank() != cards.get(i + 1).getRank()) {
                return false;
            }
        }

        return true;
    }

    private static boolean isContinuous(List<Card> cards) {
        int numberOfCards = cards.size();

        for (int i = 0; i < numberOfCards - 1; ++i) {
            if (cards.get(i + 1).getRank().compareTo(cards.get(i).getRank()) != 1) {
                return false;
            }
        }

        return true;
    }
}
