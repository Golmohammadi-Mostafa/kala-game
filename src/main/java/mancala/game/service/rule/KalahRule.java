package mancala.game.service.rule;

import mancala.game.model.Game;
import mancala.game.model.Pit;

public abstract class KalahRule {

    protected KalahRule next;

    public abstract void apply(Game game, Pit currentPit);

    public KalahRule setNext(KalahRule next) {
        this.next = next;
        return next;
    }

}
