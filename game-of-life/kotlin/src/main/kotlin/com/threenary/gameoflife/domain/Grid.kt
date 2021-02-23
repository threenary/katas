package com.threenary.gameoflife.domain

import java.io.PrintStream

class Grid(private val size: Int) {

    var cells = Array(size) { Array(size) { Cell() } }

    fun set(x: Int, y: Int, status: LivingStatus) {
        cells[x][y].livingStatus = status
    }

    fun get(x: Int, y: Int): Cell {
        return cells[x][y]
    }

    fun evolve(): Grid {
        val newGrid = Grid(size)
        for (x in 0 until size)
            for (y in 0 until size) {
                newGrid.cells[x][y] = evolveCell(x, y)
            }
        return newGrid
    }

    fun size(): Int {
        return cells.size;
    }

    private fun evolveCell(x: Int, y: Int) = cells[x][y].evolve(countLivingNeighbours(x, y))

    private fun countLivingNeighbours(row: Int, col: Int): Int {
        var count = 0;
        for (x in lowerBound(row)..upperBound(row))
            for (y in lowerBound(col)..upperBound(col)) {
                count += increaseWhenAlive(x, y)
            }
        return if (cells[row][col].isAlive()) count - 1 else count;
    }

    private fun increaseWhenAlive(x: Int, y: Int) = if (cells[x][y].isAlive()) 1 else 0

    private fun lowerBound(position: Int): Int {
        return if (position - 1 < 0) 0 else position - 1;
    }

    private fun upperBound(position: Int): Int {
        return if (position + 1 >= size) gridLimit() else position + 1;
    }

    private fun gridLimit(): Int {
        return size - 1
    }

    fun initializeWith(elements: ArrayList<ArrayList<Cell>>): Grid {
        for (row in 0 until size)
            for (col in 0 until size) {
                cells[row][col] = elements[row][col]
            }
        return this;
    }

    fun displayInOder(console: PrintStream) {
        for (row in 0 until size) {
            for (col in 0 until size) {
                console.print(get(row, col))
            }
            console.println()
        }
    }
}
