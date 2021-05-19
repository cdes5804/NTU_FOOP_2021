package Pattern;

import Entity.Card;
import java.util.List;

/**
 * The single pattern in big two.
 * Along with the comparator to compare the rank between two singles.
 */
public final class Single extends PatternBase {
    public Single(List<Card> cards) {
        super(cards);
    }
    
    @Override
    public int compareTo(PatternBase o) {
        o = (Single)o;
        return new Card.CardComparator().compare(this.cards.get(0), o.cards.get(0));
    }

    @Override
    public String toString() {
        return "single";
    }
}
