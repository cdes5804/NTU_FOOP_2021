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
    private final Card _startingCard;
    private final List<Player> _players;
    private final List<Card> _deck;
    private final PatternFactory _patternFactory;
    private int _startPlayer;

    public Game(PatternFactory patternFactory, Card startingCard) {
        _players = new ArrayList<Player>();
        _deck = new ArrayList<Card>();
        _startingCard = startingCard;
        _patternFactory = patternFactory;
        _startPlayer = -1;
    }

    public void start() {
        getDeck();
        getPlayers();

        for (int i = 0; i < NUMBER_OF_CARDS; ++i) {
            if (_startingCard.equals(_deck.get(i))) {
                _startPlayer = i % NUMBER_OF_PLAYERS;
            }

            _players.get(i % NUMBER_OF_PLAYERS).draw(_deck.get(i));
        }

        boolean isFirstRound = true;

        while (true) {
            Writer.writeRoundBegin();
            Round round = new Round(_players, _patternFactory);
            Card startingCard = isFirstRound ? _startingCard : null;
            
            round.start(_startPlayer, startingCard);
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

    private void getDeck() {
        for (int i = 0; i < NUMBER_OF_CARDS; ++i) {
            String cardString = Reader.readCard();
            _deck.add(new Card(cardString));
        }

        Collections.reverse(_deck);
    }
}