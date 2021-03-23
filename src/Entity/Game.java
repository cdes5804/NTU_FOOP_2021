package Entity;

import java.util.List;
import java.util.ArrayList;
import IO.Reader;

/**
 * A game of Big-2
 */
public class Game {
    private final int NUMBER_OF_PLAYERS = 4;
    private final int NUMBER_OF_CARDS = 4;
    private final Card _startCard;
    private final List<Player> _players;
    private int _startPlayer;

    public Game() {
        _players = new ArrayList<Player>(NUMBER_OF_PLAYERS);
        _startCard = new Card("C[3]");
        _startPlayer = -1;
    }

    public void start() {
        System.out.println("New Round begins.");
        List<Card> deck = getDeck();
        getPlayers();

        for (int i = 0; i < NUMBER_OF_CARDS; ++i) {
            if (_startCard.equals(deck.get(i))) {
                _startPlayer = i % NUMBER_OF_PLAYERS;
            }

            _players.get(i % NUMBER_OF_PLAYERS).draw(deck.get(i));
        }

        while (true) {
            Round round = new Round();
            round.start(_startPlayer);
            if (round.hasWinner) {
                break;
            }
        }
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

        return deck;
    }
}