package com.threenary.gameoflife.game

import com.threenary.gameoflife.domain.Grid
import com.threenary.gameoflife.loader.FileLoader
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.io.PrintStream

@ExtendWith(MockKExtension::class)
class GameOfLifeShould {

    private val fileName = "fileName"

    private val console = mockk<PrintStream>(relaxed = true)
    private val fileLoader = mockk<FileLoader>()

    @Test
    internal fun read_valid_input_file_and_create_a_grid() {
        val gol = GameOfLife(fileLoader, console)
        every { fileLoader.readInput() } returns Grid(2)

        gol.setup();

        verify { fileLoader.readInput() }
    }

    @Test
    internal fun inform_the_size_of_the_universe() {
        val gol = GameOfLife(fileLoader, console)
        every { fileLoader.readInput() } returns Grid(2)

        gol.setup()

        assertThat(gol.size()).isEqualTo(2)
    }

    @Test
    internal fun output_error_message_if_input_invalid() {
        every { fileLoader.readInput() } throws Exception()

        GameOfLife(fileLoader, console).setup();

        verify(atMost = 1) { console.println("There was an error parsing the input.") }
    }

    @Test
    internal fun print_result_after_play() {
        every { fileLoader.readInput() } returns Grid(2)

        val gol = GameOfLife(fileLoader, console)
        gol.setup();
        gol.play();

        verify(atMost = 6) {console.println()}
    }
}