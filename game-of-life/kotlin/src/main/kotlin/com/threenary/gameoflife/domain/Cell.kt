package com.threenary.gameoflife.domain

import com.threenary.gameoflife.domain.LivingStatus.ALIVE
import com.threenary.gameoflife.domain.LivingStatus.DEAD

data class Cell(var livingStatus: LivingStatus = DEAD) {

    fun display(): String {
        return livingStatus.representation;
    }

    fun evolve(livingNeighbours: Int) : Cell{
        return when (livingNeighbours){
            2 -> Cell(this.livingStatus)
            3 -> Cell(ALIVE)
            else -> {
                Cell()
            }
        }
    }

    fun isAlive(): Boolean {
        return livingStatus == ALIVE
    }

    override fun toString(): String {
        return livingStatus.representation
    }
}
