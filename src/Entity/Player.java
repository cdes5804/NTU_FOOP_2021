package Entity;

import IO.Reader;
import IO.Writer;
import Pattern.PatternBase;
import Pattern.Factory.PatternFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A player in a game with the action a player can take.
 */
public class Player {
    public final String name;
    public boolean isHandCardEmpty;
    private final List<Card> _handCards;

    public Player(String name) {
        this.name = name;
        isHandCardEmpty = true;
        _handCards = new ArrayList<Card>();
    }

    public void draw(Card card) {
        int index = Collections.binarySearch(_handCards, card, new Card.CardComparator());
        if (index < 0) {
            index = -index - 1;
        }
        _handCards.add(index, card);
        isHandCardEmpty = false;
    }

    public PatternBase play(PatternBase topPlay, PatternFactory patternFactory, Card startingCard) {
        PatternBase pattern = null;

        while (true) {
            pattern = null;
            Writer.writePlayerHandCards(_handCards);
            List<Integer> indices = Reader.readPlay();
            Collections.sort(indices);

            if (isPass(indices)) {
                if (topPlay != null) {
                    Writer.writePlayerPass(this);
                    break;
                } else {
                    Writer.writeInvalidPass();
                    continue;
                }
            }

            if (indices.stream().anyMatch(index -> index >= _handCards.size())) {
                Writer.writeInvalidPlay();
                continue;
            }

            List<Card> cards = new ArrayList<Card>();

            for (int index : indices) {
                cards.add(_handCards.get(index));
            }

            pattern = patternFactory.genPattern(cards);

            if (pattern != null && isValidPlay(topPlay, pattern, startingCard)) {
                Writer.writeValidPlay(this, pattern);
                removeCards(indices);

                if (_handCards.isEmpty()) {
                    isHandCardEmpty = true;
                }
                break;
            }

            Writer.writeInvalidPlay();
        }

        return pattern;
    }

    private boolean isPass(List<Integer> indices) {
        return indices.size() == 1 && indices.get(0) == -1;
    }

    private boolean isValidPlay(PatternBase prev, PatternBase curr, Card startingCard) {
        if (curr == null) {
            return false;
        } else if (startingCard != null && !curr.cards.contains(startingCard) && _handCards.contains(startingCard)) {
            return false;
        } else if (prev == null) {
            return true;
        } else if (prev.getClass().equals(curr.getClass()) == false) {
            return false;
        } else {
            return prev.compareTo(curr) < 0;
        }
    }

    private void removeCards(List<Integer> indices) {
        Collections.reverse(indices);
        for (int index : indices) {
            _handCards.remove(index);
        }
    }
}