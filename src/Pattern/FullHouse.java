package Pattern;

import Entity.Card;
import java.util.List;

public final class FullHouse extends PatternBase {
    public FullHouse() {
        super();
    }

    private FullHouse(List<Card> cards) {
        super(cards);
    }

    @Override
    public FullHouse construct(List<Card> cards) {
        return new FullHouse(cards);
    }

    @Override
    public boolean isValidPattern(List<Card> cards) {
        return cards.size() == 5 && (
            (PatternUtils.isSameRank(cards.subList(0, 2)) && PatternUtils.isSameRank(cards.subList(2, 5))) ||
            (PatternUtils.isSameRank(cards.subList(0, 3)) && PatternUtils.isSameRank(cards.subList(3, 5)))
        );
    }
    
    @Override
    public int compareTo(PatternBase o) {
        o = (FullHouse)o;
        int selfBiggestInTriple = 0;
        int otherBiggestInTriple = 0;

        if (this.cards.get(2).getRank() == this.cards.get(3).getRank()) {
            selfBiggestInTriple = 4;
        } else {
            selfBiggestInTriple = 2;
        }

        if (o.cards.get(2).getRank() == o.cards.get(3).getRank()) {
            otherBiggestInTriple = 4;
        } else {
            otherBiggestInTriple = 2;
        }

        return new Card.CardComparator().compare(this.cards.get(selfBiggestInTriple), o.cards.get(otherBiggestInTriple));
    }
}
