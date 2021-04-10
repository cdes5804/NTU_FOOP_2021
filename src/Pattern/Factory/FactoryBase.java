package Pattern.Factory;

import Entity.Card;
import Pattern.PatternBase;
import java.util.List;

public abstract class FactoryBase {
    public abstract boolean isValidPattern(List<Card> cards);
    public abstract PatternBase construct(List<Card> cards);
}
