import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardShould {

    @Test
    void show_when_remaining_living_cells_exists() {
        boolean[][] initialState = {
                {false, false, false, false, false, false, false, false,},
                {false, false, false, false, true, false, false, false,},
                {false, false, false, false, true, false, false, false,},
                {false, false, false, false, true, false, false, false,}
        };

        assertTrue(new Board(initialState).hasLivingCells());
    }

    @Test
    void kill_cell_with_less_than_two_living_neighbours() {
        boolean[][] state = {
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };
        int row = 1;
        int column = 1;

        assertFalse(new Board(state).evolveCell(row, column));
    }

    @Test
    void kill_cell_in_board_edge_with_less_than_two_living_neighbours() {
        boolean[][] state = {
                {true, false, false},
                {false, false, false},
                {false, false, true}
        };
        int row = 0;
        int column = 0;

        assertFalse(new Board(state).evolveCell(row, column));
    }

    @Test
    void kill_cells_with_more_than_three_living_neighbours() {
        boolean[][] state = {
                {false, true, false},
                {false, true, true},
                {false, true, true}
        };
        int row = 1;
        int column = 1;

        assertFalse(new Board(state).evolveCell(row, column));
    }

    @Test
    void keep_alive_cell_with_two_living_neighbours() {
        boolean[][] state = {
                {false, true, false},
                {false, true, false},
                {false, true, false}
        };
        int row = 1;
        int column = 1;

        assertTrue(new Board(state).evolveCell(row, column));
    }

    @Test
    void keep_alive_cell_with_three_living_neighbours() {
        boolean[][] state = {
                {false, true, false},
                {true, true, false},
                {false, true, false}
        };
        int row = 1;
        int column = 1;

        assertTrue(new Board(state).evolveCell(row, column));
    }

    @Test
    void bring_to_life_dead_cells_with_three_neighbours() {
        boolean[][] state = {
                {false, true, false},
                {true, false, false},
                {false, true, false}
        };
        int row = 1;
        int column = 1;

        assertTrue(new Board(state).evolveCell(row, column));
    }

    @Test
    void return_empty_board_when_empty() {
        boolean[][] emptyState = {};

        assertEquals(new Board(emptyState), new Board(emptyState).evolveBoard());
    }

    @Test
    void return_dead_board_when_only_one_alive_cell() {
        boolean[][] oneAliveCell = {{true}};
        boolean[][] oneDeadCell = {{false}};

        assertEquals(new Board(oneDeadCell),
                new Board(oneAliveCell).evolveBoard());
    }

    @Test
    void return_dead_board_when_less_than_two_neighbours() {
        boolean[][] initialState = {
                {true, false, false},
                {false, false, false}
        };
        boolean[][] expectedState = {
                {false, false, false},
                {false, false, false}
        };

        assertEquals(new Board(expectedState),
                new Board(initialState).evolveBoard());
    }

    @Test
    void return_to_life_cell_when_more_three_neighbour() {
        boolean[][] initialState = {
                {false, true, false},
                {true, true, false}
        };
        boolean[][] expectedState = {
                {true, true, true},
                {true, true, true}
        };

        assertEquals(new Board(expectedState),
                new Board(initialState).evolveBoard());
    }

    @Test
    void return_board_with_dead_middle_cell_when_more_three_neighbour() {
        boolean[][] initialState = {
                {false, true, false},
                {true, true, true},
                {false, true, false}
        };
        boolean[][] expectedState = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        assertEquals(new Board(expectedState),
                new Board(initialState).evolveBoard());
    }

    @Test
    void evolve_world_following_cell_rules() {
        boolean[][] initialState = {
                {true, false, false, true},
                {true, false, true, false},
                {true, false, false, false},
                {true, false, true, true}
        };

        boolean[][] expectedState = {
                {false, true, true, false},
                {true, false, false, true},
                {true, false, true, true},
                {false, true, false, false}
        };

        assertEquals(new Board(expectedState),
                new Board(initialState).evolveBoard());
    }
}