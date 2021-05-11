package Pattern.Factory;

import Entity.Card;
import Pattern.Straight;
import java.util.List;

/**
 * Identify a straight pattern and generate a straight object.
 */
public class StraightFactory extends FactoryBase {
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
                if (FactoryUtils.isContinuous(cards.subList(0, i)) && 
                    FactoryUtils.isContinuous(cards.subList(i, 5))) {
                    return true;
                }
            }
            return false;
        } else {
            return FactoryUtils.isContinuous(cards);
        }
    }
}
