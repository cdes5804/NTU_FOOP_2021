package Pattern;

import Entity.Card;
import java.util.List;

public final class Straight extends PatternBase {
    public Straight() {
        super();
    }

    private Straight(List<Card> cards) {
        super(cards);
    }

    @Override
    public Straight construct(List<Card> cards) {
        return new Straight(cards);
    }

    @Override
    public boolean isValidPattern(List<Card> cards) {
        if (cards.size() != 5) {
            return false;
        }
        if (cards.get(0).getRank().compareTo(cards.get(4).getRank()) == -12) {
            for (int i = 1; i < 5; ++i) {
                if (PatternUtils.isContinuous(cards.subList(0, i)) && 
                    PatternUtils.isContinuous(cards.subList(i, 5))) {
                    return true;
                }
            }
            return false;
        } else {
            return PatternUtils.isContinuous(cards);
        }
    }

    @Override
    public int compareTo(PatternBase o) {
        o = (Straight)o;
        return new Card.CardComparator().compare(this.cards.get(4), o.cards.get(4));
    }
}
