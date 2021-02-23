package com.threenary.gameoflife.domain

import com.threenary.gameoflife.domain.LivingStatus.ALIVE
import com.threenary.gameoflife.domain.LivingStatus.DEAD
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GridShould {

    @Test
    fun remain_dead_grid_when_only_one_dead_cell() {
        val resultingGrid = Grid(1).evolve()

        assertThat(resultingGrid.get(0, 0).livingStatus).isEqualTo(DEAD)
    }

    @Test
    fun evolve_to_dead_grid_when_only_one_living_cell() {
        val grid = Grid(1)
        grid.set(0, 0, ALIVE)

        val resultingGrid = grid.evolve()

        assertThat(resultingGrid.get(0, 0).livingStatus).isEqualTo(DEAD)
    }

    @Test
    fun evolve_one_additional_living_cell() {
        val grid = Grid(2)
        grid.set(0, 0, ALIVE)
        grid.set(0, 1, ALIVE)
        grid.set(1, 0, ALIVE)

        val resultingGrid = grid.evolve()

        assertThat(resultingGrid.get(0, 0).livingStatus).isEqualTo(ALIVE)
        assertThat(resultingGrid.get(0, 1).livingStatus).isEqualTo(ALIVE)
        assertThat(resultingGrid.get(1, 0).livingStatus).isEqualTo(ALIVE)
        assertThat(resultingGrid.get(1, 1).livingStatus).isEqualTo(ALIVE)
    }

    @Test
    fun kill_center_cell_due_to_overpopulation() {
        val grid = Grid(3)
        grid.set(0, 0, ALIVE)
        grid.set(0, 1, ALIVE)
        grid.set(0, 2, ALIVE)
        grid.set(2, 0, ALIVE)
        grid.set(2, 1, ALIVE)
        grid.set(2, 2, ALIVE)
        grid.set(1, 1, ALIVE)

        val resultingGrid = grid.evolve()

        assertThat(resultingGrid.get(1, 1).livingStatus).isEqualTo(DEAD);
    }

    @Test
    internal fun not_grow_beyond_grid_limits() {
        val grid = Grid(3)
        grid.set(0, 0, ALIVE)
        grid.set(0, 1, ALIVE)
        grid.set(0, 2, ALIVE)

        val resultingGrid = grid.evolve()

        assertThat(resultingGrid.get(0, 0).livingStatus).isEqualTo(DEAD)
        assertThat(resultingGrid.get(0, 1).livingStatus).isEqualTo(ALIVE)
        assertThat(resultingGrid.get(0, 2).livingStatus).isEqualTo(DEAD)
        assertThat(resultingGrid.get(1, 1).livingStatus).isEqualTo(ALIVE)
    }
}