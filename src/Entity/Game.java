package Entity;

import IO.Reader;
import IO.Writer;
import Pattern.Factory.PatternFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A game of Big-2
 */
public class Game {
    private final int NUMBER_OF_PLAYERS = 4;
    private final int NUMBER_OF_CARDS = 52;
    private final Card _startCard;
    private final List<Player> _players;
    private final PatternFactory _patternFactory;
    private int _startPlayer;

    public Game(PatternFactory patternFactory) {
        _players = new ArrayList<Player>(NUMBER_OF_PLAYERS);
        _startCard = new Card("C[3]");
        _patternFactory = patternFactory;
        _startPlayer = -1;
    }

    public void start() {
        List<Card> deck = getDeck();
        getPlayers();

        for (int i = 0; i < NUMBER_OF_CARDS; ++i) {
            if (_startCard.equals(deck.get(i))) {
                _startPlayer = i % NUMBER_OF_PLAYERS;
            }

            _players.get(i % NUMBER_OF_PLAYERS).draw(deck.get(i));
        }

        while (true) {
            Writer.writeRoundBegin();
            Round round = new Round(_players);
            round.start(_startPlayer, _patternFactory);
            _startPlayer = round.lastPlayer;

            if (round.hasWinner) {
                break;
            }
        }

        int winner = _startPlayer;
        Writer.writeWinner(_players.get(winner));
    }

    private void getPlayers() {
        for (int i = 0; i < NUMBER_OF_PLAYERS; ++i) {
            String playerName = Reader.readPlayerName();
            _players.add(new Player(playerName));
        }
    }

    private List<Card> getDeck() {
        List<Card> deck = new ArrayList<Card>();

        for (int i = 0; i < NUMBER_OF_CARDS; ++i) {
            String cardString = Reader.readCard();
            deck.add(new Card(cardString));
        }

        Collections.reverse(deck);

        return deck;
    }
}