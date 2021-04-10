package Pattern;

import Entity.Card;
import java.util.List;

/**
 * The pair pattern in big two.
 * Along with the comparator to compare the rank between two pairs.
 */
public final class Pair extends PatternBase {
    public Pair(List<Card> cards) {
        super(cards);
    }

    @Override
    public int compareTo(PatternBase o) {
        o = (Pair)o;
        return new Card.CardComparator().compare(this.cards.get(1), o.cards.get(1));
    }
}
