package Pattern;

import Entity.Card;
import java.util.List;

/**
 * The straight pattern in big two.
 * Along with the comparator to compare the rank between two straights.
 */
public final class Straight extends PatternBase {
    public Straight(List<Card> cards) {
        super(cards);
    }

    @Override
    public int compareTo(PatternBase o) {
        o = (Straight)o;
        return new Card.CardComparator().compare(this.cards.get(4), o.cards.get(4));
    }
}
