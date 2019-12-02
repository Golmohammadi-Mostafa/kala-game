package mancala.game.model;


/**
 * This class represent the game. A game contain players, board, games status and updateTime time.
 * Date 12/01/2019 9:05 AM
 *
 * @author mostafa golmohammadi
 */


public class Game {

    private String id;
    private Board board;
    private Player player1;
    private Player player2;
    private Player winner;
    private GameStatus gameStatus;
    private Long updateAt;

    public Game(Integer initialStoneOnPit) {
        this.player1 = new Player(Player.PLAYER1_INDEX, "player1");
        this.player2 = new Player(Player.PLAYER2_INDEX, "player2");
        this.board = new Board(initialStoneOnPit, player1, player2);
        this.gameStatus = GameStatus.INIT;
        this.updateAt = System.currentTimeMillis();
    }

    /**
     * This method is set the time of the last activity.
     */
    public void updateTime() {
        this.setUpdateAt(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}
