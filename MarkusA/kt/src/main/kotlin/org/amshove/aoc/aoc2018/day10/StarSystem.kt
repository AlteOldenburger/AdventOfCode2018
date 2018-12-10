package org.amshove.aoc.aoc2018.day10

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun formsText(sky: Sky): Boolean {
    val minY = sky.minBy { it.position.y }!!.position.y
    val maxY = sky.maxBy { it.position.y }!!.position.y
    return maxY - minY == 9
}

@ExperimentalContracts
fun showSky(sky: Sky) {
    val xCoordinates = sky.map { it.position.x }
    val yCoordinates = sky.map { it.position.y }

    val minX = xCoordinates.min()
    val maxX = xCoordinates.max()
    val minY = yCoordinates.min()
    val maxY = yCoordinates.max()

    // `min` und `max` geben `T?` zurueck
    if (anyNull(minX, maxX, minY, maxY)) {
        throw Exception("Coordinates can't be null")
    }

    // smartCast minX und maxX zu `Int` statt `Int?` durch anyNull
    for (y in minY..maxY) {
        for (x in minX..maxX) {
            print(if (sky.any { it.position.x == x && it.position.y == y }) "#" else ".")
        }
        println()
    }
}

@ExperimentalContracts
private fun anyNull(x: Any?, y: Any?, vx: Any?, vy: Any?): Boolean {
    contract {
        returns() implies (x != null && y != null && vx != null && vy != null)
    }
    return x == null || y == null || vx == null || vy == null
}
