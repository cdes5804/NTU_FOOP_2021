package Pattern;

import Entity.Card;
import java.util.List;

public final class Pair extends PatternBase {
    public Pair() {
        super();
    }

    private Pair(List<Card> cards) {
        super(cards);
    }

    @Override
    public Pair construct(List<Card> cards) {
        return new Pair(cards);
    }

    @Override
    public boolean isValidPattern(List<Card> cards) {
        return cards.size() == 2 && PatternUtils.isSameRank(cards);
    }

    @Override
    public int compareTo(PatternBase o) {
        o = (Pair)o;
        return new Card.CardComparator().compare(this.cards.get(1), o.cards.get(1));
    }
}
