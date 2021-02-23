package com.threenary.gameoflife.domain

import com.threenary.gameoflife.domain.LivingStatus.ALIVE
import com.threenary.gameoflife.domain.LivingStatus.DEAD
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CellShould{

    @Test
    internal fun display_0_when_is_dead() {
        assertThat(Cell(DEAD).display()).isEqualTo("O");
    }

    @Test
    internal fun display_dot_when_is_alive() {
        assertThat(Cell(ALIVE).display()).isEqualTo(".");
    }

    @Test
    internal fun die_when_less_than_two_neighbours() {
        assertThat(Cell(ALIVE).evolve(1).display()).isEqualTo(DEAD.representation)
    }

    @Test
    internal fun survive_if_two_neighbours() {
        assertThat(Cell(ALIVE).evolve(2).display()).isEqualTo(ALIVE.representation)
    }

    @Test
    internal fun survive_if_three_neighbours() {
        assertThat(Cell(ALIVE).evolve(3).display()).isEqualTo(ALIVE.representation)
    }

    @Test
    internal fun remain_dead_if_two_neighbours() {
        assertThat(Cell(DEAD).evolve(2).display()).isEqualTo(DEAD.representation)
    }

    @Test
    internal fun come_to_life_if_exactly_three_neighbours() {
        assertThat(Cell(DEAD).evolve(3).display()).isEqualTo(ALIVE.representation)
    }

    @Test
    internal fun die_if_overpopulation() {
        assertThat(Cell(DEAD).evolve(6).display()).isEqualTo(DEAD.representation)
    }
}