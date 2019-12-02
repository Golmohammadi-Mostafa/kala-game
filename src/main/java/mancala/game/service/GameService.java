package mancala.game.service;


import mancala.game.model.Game;

public interface GameService {

    Game initGame(Integer pitNumber);

    Game play(String gameId, Integer pitId);
}
