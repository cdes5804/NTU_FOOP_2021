package Entity;

import IO.Writer;
import Pattern.PatternBase;
import Pattern.Factory.PatternFactory;
import java.util.List;

public class Round {
    public boolean hasWinner;
    public int lastPlayer;
    private List<Player> _players;
    private int _passCount;
    private PatternBase _topPlay;

    public Round(List<Player> players) {
        hasWinner = false;
        lastPlayer = -1;
        _players = players;
        _passCount = 0;
        _topPlay = null;
    }

    public void start(int startPlayer, PatternFactory patternFactory) {
        int numberOfPlayers = _players.size();
        int currentPlayer = startPlayer;

        while (_passCount < 3 && !hasWinner) {
            Player player = _players.get(currentPlayer);

            Writer.writePlayerTurn(player);

            PatternBase play = player.play(_topPlay, patternFactory);

            if (play == null) {
                _passCount++;
            } else {
                _topPlay = play;
                lastPlayer = currentPlayer;
                _passCount = 0;

                if (player.finished) {
                    hasWinner = true;
                }
            }

            currentPlayer = (currentPlayer + 1) % numberOfPlayers;
        }
    }
}