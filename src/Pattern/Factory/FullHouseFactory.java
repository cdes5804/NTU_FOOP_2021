package Pattern.Factory;

import Entity.Card;
import Pattern.FullHouse;
import java.util.List;

public class FullHouseFactory extends FactoryBase {
    @Override
    public FullHouse construct(List<Card> cards) {
        return new FullHouse(cards);
    }

    @Override
    public boolean isValidPattern(List<Card> cards) {
        return cards.size() == 5 && (
            (FactoryUtils.isSameRank(cards.subList(0, 2)) && FactoryUtils.isSameRank(cards.subList(2, 5))) ||
            (FactoryUtils.isSameRank(cards.subList(0, 3)) && FactoryUtils.isSameRank(cards.subList(3, 5)))
        );
    }
}
