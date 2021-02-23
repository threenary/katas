package com.threenary.gameoflife.loader

import com.threenary.gameoflife.domain.LivingStatus.ALIVE
import com.threenary.gameoflife.domain.LivingStatus.DEAD
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

//TODO
// There are many edge cases regarding typos in the input
// file that I am leaving outside of the scope
class FileLoaderShould {

    @Test
    internal fun throw_exception_when_no_cell_is_found() {
        val fileName = "no_cell_file.gol"

        assertFailsWith(Exception::class) {
            FileLoader(fileName).readInput()
        }
    }

    @Test
    internal fun load_grid_with_only_one_dead_cell() {
        val fileName = "single_dead_cell.gol"

        val grid = FileLoader(fileName).readInput()

        assertThat(grid.get(0, 0).livingStatus).isEqualTo(DEAD)
    }

    @Test
    internal fun load_grid_with_only_one_alive_cell() {
        val fileName = "single_dead_cell.gol"

        val grid = FileLoader(fileName).readInput()

        assertThat(grid.get(0, 0).livingStatus).isEqualTo(DEAD)
    }

    @Test
    internal fun load_grid_random_valid_input() {
        val fileName = "valid_input.gol"

        val grid = FileLoader(fileName).readInput()

        for (i in 0..3) {
            assertThat(grid.get(0, i).livingStatus).isEqualTo(ALIVE)
            assertThat(grid.get(3, i).livingStatus).isEqualTo(ALIVE)
        }

        assertThat(grid.get(1, 0).livingStatus).isEqualTo(ALIVE)
        assertThat(grid.get(1, 1).livingStatus).isEqualTo(ALIVE)
        assertThat(grid.get(1, 2).livingStatus).isEqualTo(DEAD)
        assertThat(grid.get(1, 3).livingStatus).isEqualTo(DEAD)

        assertThat(grid.get(2, 0).livingStatus).isEqualTo(ALIVE)
        assertThat(grid.get(2, 1).livingStatus).isEqualTo(DEAD)
        assertThat(grid.get(2, 2).livingStatus).isEqualTo(DEAD)
        assertThat(grid.get(2, 3).livingStatus).isEqualTo(DEAD)
    }
}
