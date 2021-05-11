package Pattern.Factory;

import Entity.Card;
import Pattern.Pair;
import java.util.List;

/**
 * Identify a pair pattern and generate a pair object.
 */
public class PairFactory extends FactoryBase {
    @Override
    public Pair construct(List<Card> cards) {
        return new Pair(cards);
    }

    @Override
    public boolean isValidPattern(List<Card> cards) {
        return cards.size() == 2 && FactoryUtils.isSameRank(cards);
    }
}
