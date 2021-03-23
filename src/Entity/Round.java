package Entity;

import java.util.List;

import IO.Writer;
import Pattern.PatternBase;

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

    public void start(int startPlayer) {
        int numberOfPlayers = _players.size();
        int currentPlayer = startPlayer;

        while (_passCount < 3 && !hasWinner) {
            Player player = _players.get(currentPlayer);

            Writer.writePlayerTurn(player);

            PatternBase play = player.play(_topPlay);

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