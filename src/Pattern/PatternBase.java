package Pattern;

import java.util.List;

/**
 * The base class for all card patterns in Big-2
 */
public abstract class PatternBase {
    protected List<String> cards;

    /**
     * Compare the order of two plays of the same pattern.
     * 
     * @param A a play of the same pattern.
     * @return true if the play has higher order than the one passed as parameter, otherwise false.
     */
    abstract public boolean biggerThan();

    /**
     * Check if the given cards form a valid pattern.
     * 
     * @return true if the given cards form a valid patten, otherwise false.
     */
    abstract protected boolean isValidPattern();
}