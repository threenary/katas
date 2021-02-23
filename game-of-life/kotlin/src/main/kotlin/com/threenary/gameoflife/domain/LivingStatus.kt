package com.threenary.gameoflife.domain

enum class LivingStatus(val representation: String) {
    DEAD("O"),
    ALIVE(".");

    companion object {
        private val map = LivingStatus.values().associateBy(LivingStatus::representation)
        fun fromRepresentation(type: String) = map[type]
    }

}
