package Pattern;

import Entity.Card;
import java.util.List;

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
