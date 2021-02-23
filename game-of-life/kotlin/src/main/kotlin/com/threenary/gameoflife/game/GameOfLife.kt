package com.threenary.gameoflife.game

import com.threenary.gameoflife.domain.Grid
import com.threenary.gameoflife.loader.FileLoader
import java.io.PrintStream

class GameOfLife(private val gameLoader: FileLoader, private val console: PrintStream) {

    private lateinit var grid: Grid

    fun setup(): GameOfLife {
        try {
            grid = gameLoader.readInput()
        } catch (e: Exception) {
            console.println("There was an error parsing the input.")
        }
        return this;
    }

    fun play(){
        grid = grid.evolve()
        display()
    }

    private fun display(){
        console.println("------------------")
        grid.displayInOder(console)
        console.println("------------------")
    }

    fun size(): Int {
        return grid.size()
    }


}
