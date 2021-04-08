package Pattern;

import java.util.List;
import Entity.Card;

/**
 * The base class for all card patterns in Big-2
 */
public abstract class PatternBase implements Comparable<PatternBase> {
    public List<Card> cards;

    public PatternBase() {};

    protected PatternBase(List<Card> cards) {
        this.cards = cards;
    }

    abstract public PatternBase construct(List<Card> cards);
    abstract public boolean isValidPattern(List<Card> cards);
}