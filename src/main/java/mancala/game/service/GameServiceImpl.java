package mancala.game.service;

import mancala.game.repository.GameMemoryRepository;
import mancala.game.model.Game;
import mancala.game.model.Pit;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * This class works as bridge between controller and game engine.
 * Date 12/01/2019 9:05 AM
 *
 * @author mostafa golmohammadi
 */


@Service
public class GameServiceImpl implements GameService {
    Logger log = Logger.getLogger(GameServiceImpl.class.getName());
    private final GameMemoryRepository gameMemoryRepository;
    private final GameEngine gameEngine;

    public GameServiceImpl(GameMemoryRepository gameMemoryRepository, GameEngine gameEngine) {
        this.gameMemoryRepository = gameMemoryRepository;
        this.gameEngine = gameEngine;
    }

    /**
     * This method is responsible to initialize new game
     *
     * @param initialPitStoneCount is the initial number of stone.
     * @return Game
     */
    @Override
    public Game initGame(Integer initialPitStoneCount) {
        return gameMemoryRepository.create(initialPitStoneCount);
    }


    /**
     * This method is responsible for every new move of the stones from a pit.
     *
     * @param gameId   game id
     * @param pitIndex index of the pit
     * @return Game
     */
    @Override
    public Game play(String gameId, Integer pitIndex) {
        log.info("gameId {}, pitIndex {}, " + gameId + pitIndex);

        Game game = gameMemoryRepository.findById(gameId);
        Pit pit = game.getBoard().getPitByPitIndex(pitIndex);

        gameEngine.play(game, pit);
        return game;
    }

}
