package org.amshove.aoc.aoc2018.day10

typealias Sky = List<Star> // Immutable

inline class Position(private val coordinates: Pair<Int, Int>) {
    val x get() = coordinates.first
    val y get() = coordinates.second
}

inline class Velocity(private val speedPair: Pair<Int, Int>) {
    val deltaX get() = speedPair.first
    val deltaY get() = speedPair.second
}

data class Star(val position: Position, val velocity: Velocity) {
    fun moveOn() = copy(
        Position(position.x + velocity.deltaX to position.y + velocity.deltaY)
        // Velocity nicht noetig, copy ist ein "wither"
    )
}
