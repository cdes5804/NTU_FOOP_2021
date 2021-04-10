package Pattern.Factory;

import Entity.Card;
import Pattern.Single;
import java.util.List;

public class SingleFactory extends FactoryBase {
    @Override
    public Single construct(List<Card> cards) {
        return new Single(cards);
    }

    @Override
    public boolean isValidPattern(List<Card> cards) {
        return cards.size() == 1;
    }
}
