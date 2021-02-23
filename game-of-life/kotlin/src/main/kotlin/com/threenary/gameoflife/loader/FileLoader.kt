package com.threenary.gameoflife.loader

import com.threenary.gameoflife.domain.Cell
import com.threenary.gameoflife.domain.Grid
import com.threenary.gameoflife.domain.LivingStatus.Companion.fromRepresentation
import java.io.File
import java.net.URL

class FileLoader(private val fileName: String) {

    fun readInput(): Grid {
        val file = readFile(fileName)
        val elements = ArrayList<ArrayList<Cell>>()

        file.forEachLine {
            if (!startsWithInvalidChar(it)) {
                parseLine(elements, it)
            }
        }
        return buildGrid(elements)
    }

    private fun parseLine(elements: ArrayList<ArrayList<Cell>>, it: String) {
        elements.add(parseLine(it))
    }

    private fun startsWithInvalidChar(it: String) = it.startsWith("!")

    private fun createCell(char: Char) = Cell(fromRepresentation(char.toString()) ?: throw Exception())

    @Throws(Exception::class)
    private fun buildGrid(elements: java.util.ArrayList<java.util.ArrayList<Cell>>): Grid {
        if (elements.size == 0)
            throw Exception("Invalid file")

        return Grid(elements.size).initializeWith(elements)
    }

    private fun parseLine(line: String): java.util.ArrayList<Cell> {
        val row = ArrayList<Cell>()
        line.toCharArray().forEach { char ->
            row.add(createCell(char))
        }
        return row;
    }

    // This is definitely not the best approach but it was driving me crazy to open a file
    // I always struggle to read files from resources, don't you?
    private fun readFile(fileName: String): File {
        val url: URL? = Thread.currentThread().contextClassLoader.getResource(fileName)
        return File(url?.toURI())
    }


}
