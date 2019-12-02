package mancala.game.service.rule;

import mancala.game.model.Pit;
import mancala.game.model.Game;

import java.util.logging.Logger;

/**
 * This class is responsible to distribute to the next pits
 * except for the opponent house.
 * Date 12/01/2019 9:05 AM
 *
 * @author mostafa golmohammadi
 */
public class DistributePitStoneRule extends KalahRule {
    Logger log = Logger.getLogger(DistributePitStoneRule.class.getName());

    @Override
    public void apply(Game game, Pit currentPit) {
        log.info("check the rules for distributing stone to the next pit(s)");

        Integer stoneToDistribute = currentPit.getStoneCount();
        currentPit.setStoneCount(0);

        for (int i = 0; i < stoneToDistribute; i++) {
            currentPit = game.getBoard().getNextPit(currentPit);
            log.info("next pit {}" + currentPit);
            if (currentPit.isDistributable(game.getGameStatus())) {
                currentPit.setStoneCount(currentPit.getStoneCount() + 1);
            } else {
                i--;
            }
        }

        this.next.apply(game, currentPit);
    }


}
