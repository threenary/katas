import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeShould {

    boolean[][] initialState =
            {{false, false, false, false, false, false, false, false,},
                    {false, false, false, false, true, false, false, false,},
                    {false, false, false, false, true, false, false, false,},
                    {false, false, false, false, true, false, false, false,}};

    boolean[][] deadState =
            {{false, false, false, false, false, false, false, false,},
                    {false, false, false, false, false, false, false, false,},
                    {false, false, false, false, false, false, false, false,},
                    {false, false, false, false, false, false, false, false,}};

    @Test
    void return_true_if_board_has_living_cells() {
        Board board = new Board(initialState);

        assertTrue(new GameOfLife(board).hasLivingCells());
    }

    @Test
    void return_false_when_no_living_cells() {
        Board board = new Board(deadState);

        assertFalse(new GameOfLife(board).hasLivingCells());
    }
}