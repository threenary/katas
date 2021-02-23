package com.threenary.gameoflife

import com.threenary.gameoflife.game.GameOfLife
import com.threenary.gameoflife.loader.FileLoader

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            args.iterator().forEach { _ ->
                GameOfLife(FileLoader(args[0]), System.out).setup().play()
            }
        }
    }
}

