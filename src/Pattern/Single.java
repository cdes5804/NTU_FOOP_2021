package Pattern;

import Entity.Card;
import java.util.List;

public final class Single extends PatternBase {
    public Single(List<Card> cards) {
        super(cards);
    }
    
    @Override
    public int compareTo(PatternBase o) {
        o = (Single)o;
        return new Card.CardComparator().compare(this.cards.get(0), o.cards.get(0));
    }
}
