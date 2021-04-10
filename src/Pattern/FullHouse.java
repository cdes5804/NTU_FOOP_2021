package Pattern;

import Entity.Card;
import java.util.List;

public final class FullHouse extends PatternBase {
    public FullHouse(List<Card> cards) {
        super(cards);
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
