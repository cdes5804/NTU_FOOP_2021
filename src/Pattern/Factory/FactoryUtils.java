package Pattern.Factory;

import Entity.Card;
import java.util.List;

public class FactoryUtils {
    public static boolean isSameRank(List<Card> cards) {
        int numberOfCards = cards.size();

        for (int i = 0; i < numberOfCards - 1; ++i) {
            if (cards.get(i).getRank() != cards.get(i + 1).getRank()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isContinuous(List<Card> cards) {
        int numberOfCards = cards.size();

        for (int i = 0; i < numberOfCards - 1; ++i) {
            if (cards.get(i + 1).getRank().compareTo(cards.get(i).getRank()) != 1) {
                return false;
            }
        }

        return true;
    }
}
