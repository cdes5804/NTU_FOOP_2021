package Entity;

import IO.Writer;
import Pattern.PatternBase;
import Pattern.Factory.PatternFactory;
import java.util.List;

/**
 * A round consists of serveral actions from the players.
 * A round ends when there are three consecutive passes.
 */
public class Round {
    public boolean hasWinner;
    public int lastPlayer;
    private List<Player> _players;
    private int _passCount;
    private PatternBase _topPlay;
    private PatternFactory _patternFactory;

    public Round(List<Player> players, PatternFactory patternFactory) {
        hasWinner = false;
        lastPlayer = -1;
        _players = players;
        _passCount = 0;
        _topPlay = null;
        _patternFactory = patternFactory;
    }

    public void start(int startPlayer, Card startingCard) {
        int numberOfPlayers = _players.size();
        int currentPlayer = startPlayer;

        while (_passCount < 3 && !hasWinner) {
            Player player = _players.get(currentPlayer);

            Writer.writePlayerTurn(player);

            PatternBase play = player.play(_topPlay, _patternFactory, startingCard);

            if (play == null) {
                _passCount++;
            } else {
                _topPlay = play;
                lastPlayer = currentPlayer;
                _passCount = 0;

                if (player.isHandCardEmpty) {
                    hasWinner = true;
                }
            }

            currentPlayer = (currentPlayer + 1) % numberOfPlayers;
        }
    }
}