package mancala.game.model;

import mancala.game.exception.KalahException;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represent the board of the game. Board contain all the pits.
 * Date 12/01/2019 9:02 AM
 *
 * @author mostafa golmohammadi
 */


public class Board {

    public static final Integer PIT_START_INDEX = 1;
    public static final Integer PIT_END_INDEX = 14;
    public static final Integer PLAYER1_HOUSE = 7;
    public static final Integer PLAYER2_HOUSE = 14;
    public static final Integer INITIAL_STONE_ON_PIT = 6;
    public static final Integer INITIAL_STONE_ON_HOUSE = 0;

    private Map<Integer, Pit> pits;

    public Board(Integer initialStoneOnPit, Player player1, Player player2) {
        this.pits = initPit(initialStoneOnPit, player1, player2);
    }


    public Board() {

    }

    public static Integer getPitStartIndex() {
        return PIT_START_INDEX;
    }

    public static Integer getPitEndIndex() {
        return PIT_END_INDEX;
    }

    public static Integer getPlayer1House() {
        return PLAYER1_HOUSE;
    }

    public static Integer getPlayer2House() {
        return PLAYER2_HOUSE;
    }

    public static Integer getInitialStoneOnPit() {
        return INITIAL_STONE_ON_PIT;
    }

    public static Integer getInitialStoneOnHouse() {
        return INITIAL_STONE_ON_HOUSE;
    }

    public Map<Integer, Pit> getPits() {
        return pits;
    }

    public void setPits(Map<Integer, Pit> pits) {
        this.pits = pits;
    }

    /**
     * @param pitIndex Pit index.
     * @return Integer number of total stone on a pit
     */
    public Integer getStoneCountByPitIndex(Integer pitIndex) {
        return getPitByPitIndex(pitIndex).getStoneCount();
    }

    public Pit getPlayerHouse(Integer playerIndex) {
        if (playerIndex.equals(Player.PLAYER1_INDEX)) {
            return pits.get(Board.PLAYER1_HOUSE);
        } else if (playerIndex.equals(Player.PLAYER2_INDEX)) {
            return pits.get(Board.PLAYER2_HOUSE);
        }

        throw new KalahException("playerIndex is not correct");
    }

    public Pit getPitByPitIndex(Integer pitIndex) {
        return pits.get(pitIndex);
    }

    public Pit getNextPit(Pit pit) {
        return pits.get(pit.nextPitIndex());
    }

    public Pit getOppositePit(Pit pit) {
        return pits.get(pit.getOppositePitIndex());
    }

    public Integer getPlayer1PitStoneCount() {
        Integer player1PitStoneCount = 0;
        for (int i = Board.PIT_START_INDEX; i < Board.PLAYER1_HOUSE; i++) {
            player1PitStoneCount += this.getPits().get(i).getStoneCount();
        }
        return player1PitStoneCount;
    }

    public Integer getPlayer2PitStoneCount() {
        Integer player2PitStoneCount = 0;
        for (int i = Board.PLAYER1_HOUSE + 1; i < Board.PLAYER2_HOUSE; i++) {
            player2PitStoneCount += this.getPits().get(i).getStoneCount();
        }
        return player2PitStoneCount;
    }

    private Map<Integer, Pit> initPit(Integer initialStoneOnPit, Player player1, Player player2) {

        Map<Integer, Pit> pits = new ConcurrentHashMap<>();
        for (int i = Board.PIT_START_INDEX; i < Board.PLAYER1_HOUSE; i++) {
            Pit pit = new Pit(i, initialStoneOnPit, player1.getPlayerIndex());
            pits.put(i, pit);
        }
        Pit house1 = new Pit(Board.PLAYER1_HOUSE, Board.INITIAL_STONE_ON_HOUSE, player1.getPlayerIndex());
        pits.put(Board.PLAYER1_HOUSE, house1);


        for (int i = Board.PLAYER1_HOUSE + 1; i < Board.PLAYER2_HOUSE; i++) {
            Pit pit = new Pit(i, initialStoneOnPit, player2.getPlayerIndex());
            pits.put(i, pit);
        }
        Pit house2 = new Pit(Board.PLAYER2_HOUSE, Board.INITIAL_STONE_ON_HOUSE, player2.getPlayerIndex());
        pits.put(Board.PLAYER2_HOUSE, house2);

        return pits;
    }


}
