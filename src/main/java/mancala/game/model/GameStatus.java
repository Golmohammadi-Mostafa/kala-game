package mancala.game.model;

/**
 * Identifies the current game status
 * Date 12/01/2019 9:06 AM
 *
 * @author mostafa golmohammadi
 */
public enum GameStatus {

    /**
     * Game was initiated but not started.
     */
    INIT,

    /**
     * Player 1 is on the turn
     */
    PLAYER1_TURN,

    /**
     * Player 2 is on the turn
     */
    PLAYER2_TURN,

    /**
     * Game has finished
     */
    FINISHED
}
