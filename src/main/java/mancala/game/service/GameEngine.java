package mancala.game.service;

import mancala.game.model.Game;
import mancala.game.model.Pit;
import mancala.game.service.rule.*;
import org.springframework.stereotype.Component;

/**
 * This class represent the game rule chain.
 * Date 12/01/2019 9:05 AM
 *
 * @author mostafa golmohammadi
 */
@Component
public class GameEngine {

    private final KalahRule chain;

    public GameEngine() {

        this.chain = new StartPitRule();
        chain.setNext(new DistributePitStoneRule())
                .setNext(new EndPitRule())
                .setNext(new GameOver());
    }

    public void play(Game game, Pit pit) {
        this.chain.apply(game, pit);
    }

}
