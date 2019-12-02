package mancala.game.model;

/**
 * This class represent the player of the game.
 * Date 12/01/2019 9:05 AM
 *
 * @author mostafa golmohammadi
 */


public class Player {

    public static final Integer PLAYER1_INDEX = 1;
    public static final Integer PLAYER2_INDEX = 2;
    private Integer playerIndex;
    private String name;

    public Player(Integer playerIndex, String name) {
        this.name = name;
        this.playerIndex = playerIndex;
    }

    public static Integer getPlayer1Index() {
        return PLAYER1_INDEX;
    }

    public static Integer getPlayer2Index() {
        return PLAYER2_INDEX;
    }

    public Integer getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(Integer playerIndex) {
        this.playerIndex = playerIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
