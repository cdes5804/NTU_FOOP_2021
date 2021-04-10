package Pattern.Factory;

import Entity.Card;
import Pattern.PatternBase;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The factory that aggregates all pattern factories.
 * Used to test a list of cards against all registered pattern factories and generate an appropriate object.
 */
public class PatternFactory {
    private List<FactoryBase> _patterns;

    public PatternFactory() {
        _patterns = new ArrayList<FactoryBase>();
    }

    public void register(FactoryBase pattern) {
        _patterns.add(pattern);
    }

    public PatternBase genPattern(List<Card> cards) {
        Collections.sort(cards, new Card.CardComparator());

        for (FactoryBase pattern : _patterns) {
            if (pattern.isValidPattern(cards)) {
                return pattern.construct(cards);
            }
        }

        return null;
    }
}
