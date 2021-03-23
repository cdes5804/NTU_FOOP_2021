package Entity;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player {
    private final String _name;
    private final List<Card> _handCards;

    public Player(String name) {
        _name = name;
        _handCards = new ArrayList<Card>();
    }

    public void draw(Card card) {
        int index = Collections.binarySearch(_handCards, card, new Card.CardComparator());
        if (index < 0) {
            index = -index - 1;
        }
        _handCards.add(index, card);
    }
}