public class GameOfLife {

    private Board board;

    public GameOfLife(Board board) {
        this.board = board;
    }

    public void nextGen() {
        board = board.evolveBoard();
    }

    public boolean hasLivingCells() {
        return board.hasLivingCells();
    }
}
