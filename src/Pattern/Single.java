package Pattern;

import Entity.Card;
import java.util.List;

public final class Single extends PatternBase {
    public Single() {
        super();
    }

    private Single(List<Card> cards) {
        super(cards);
    }

    @Override
    public Single construct(List<Card> cards) {
        return new Single(cards);
    }

    @Override
    public boolean isValidPattern(List<Card> cards) {
        return cards.size() == 1;
    }
    
    @Override
    public int compareTo(PatternBase o) {
        o = (Single)o;
        return new Card.CardComparator().compare(this.cards.get(0), o.cards.get(0));
    }
}
