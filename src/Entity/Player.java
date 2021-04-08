package Entity;

import IO.Reader;
import IO.Writer;
import Pattern.PatternBase;
import Pattern.PatternFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    public final String name;
    public boolean finished;
    public final List<Card> handCards;

    public Player(String name) {
        this.name = name;
        this.finished = false;
        handCards = new ArrayList<Card>();
    }

    public void draw(Card card) {
        int index = Collections.binarySearch(handCards, card, new Card.CardComparator());
        if (index < 0) {
            index = -index - 1;
        }
        handCards.add(index, card);
    }

    public PatternBase play(PatternBase topPlay, PatternFactory patternFactory) {
        PatternBase pattern = null;

        while (true) {
            pattern = null;
            Writer.writePlayerHandCards(this);
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

            if (indices.stream().anyMatch(index -> index >= handCards.size())) {
                Writer.writeInvalidPlay();
                continue;
            }

            List<Card> cards = new ArrayList<Card>();

            for (int index : indices) {
                cards.add(handCards.get(index));
            }

            pattern = patternFactory.genPattern(cards);

            if (pattern != null && isValidPlay(topPlay, pattern)) {
                Writer.writeValidPlay(this, pattern);
                removeCards(indices);

                if (handCards.isEmpty()) {
                    finished = true;
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

    private boolean isValidPlay(PatternBase prev, PatternBase curr) {
        Card startingCard = new Card("C[3]");

        if (curr == null) {
            return false;
        } else if (!curr.cards.contains(startingCard) && handCards.contains(startingCard)) {
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
            handCards.remove(index);
        }
    }
}