package Pattern;

import Entity.Card;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class PatternFactory {
    private List<PatternBase> _patterns;

    public PatternFactory() {
        _patterns = new ArrayList<PatternBase>();
    }

    public void register(PatternBase pattern) {
        _patterns.add(pattern);
    }

    public PatternBase genPattern(List<Card> cards) {
        Collections.sort(cards, new Card.CardComparator());

        for (PatternBase pattern : _patterns) {
            if (pattern.isValidPattern(cards)) {
                return pattern.construct(cards);
            }
        }

        return null;
    }
}
