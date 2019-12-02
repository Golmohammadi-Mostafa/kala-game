package mancala.game.api;

import mancala.game.exception.KalahException;
import mancala.game.model.Board;
import mancala.game.service.GameService;
import mancala.game.exception.KalahIllegalMoveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * This is the end point of this game.
 * Date 12/01/2019 8:59 AM
 *
 * @author mostafa golmohammadi
 */


@RestController
@RequestMapping("/api/kalah")
public class GameApi {
    Logger log = Logger.getLogger(GameApi.class.getName());
    private final GameService gameService;

    public GameApi(GameService gameService) {
        this.gameService = gameService;
    }


    @PostMapping(value = "/games")
    public ResponseEntity initBoard(@RequestParam(name = "stone", defaultValue = "6", required = false) Integer numberOfStone) {
        log.info("initializing kalah game");
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.initGame(numberOfStone));
    }


    @PutMapping("/games/{gameId}/pits/{pitIndex}")
    public ResponseEntity play(@PathVariable String gameId, @PathVariable Integer pitIndex) {
        log.info("From game {}, player {} is moving stone from pit {}," + gameId + " " + pitIndex);

        if (pitIndex > Board.PIT_END_INDEX || pitIndex < Board.PIT_START_INDEX) {
            throw new KalahException("Incorrect pit index");
        }

        if (pitIndex.equals(Board.PLAYER1_HOUSE) || pitIndex.equals(Board.PLAYER2_HOUSE)) {
            throw new KalahIllegalMoveException("House stone is not allow to distribute");
        }

        return ResponseEntity.ok().body(gameService.play(gameId, pitIndex));
    }

}
