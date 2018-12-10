package org.amshove.aoc.aoc2018.day10

import kotlin.contracts.ExperimentalContracts
import kotlin.system.measureTimeMillis

@ExperimentalContracts
fun main() {
    measureTimeMillis {
        val input = Star::class.java.getResource("/day10.txt").readText()
        var currentSky = createInitialSky(input)
        var elapsedSeconds = 0

        while (!formsText(currentSky)) {
            currentSky = currentSky.map { it.moveOn() }
            elapsedSeconds++
        }

        showSky(currentSky)
        println("Took $elapsedSeconds seconds")
        /*
#####...######..######..######...####...#....#..#....#..######
#....#..#.......#............#..#....#..##...#..#....#..#.....
#....#..#.......#............#..#.......##...#...#..#...#.....
#....#..#.......#...........#...#.......#.#..#...#..#...#.....
#####...#####...#####......#....#.......#.#..#....##....#####.
#....#..#.......#.........#.....#.......#..#.#....##....#.....
#....#..#.......#........#......#.......#..#.#...#..#...#.....
#....#..#.......#.......#.......#.......#...##...#..#...#.....
#....#..#.......#.......#.......#....#..#...##..#....#..#.....
#####...#.......#.......######...####...#....#..#....#..######
     */
    }.run {
        println("Completion took $this milliseconds")
    }
}

fun createInitialSky(input: String): Sky =
    input
        .split("\n")
        .map { it.replace(" ", "") }
        .filterNot(String::isEmpty)
        .map(::parseStar)

private fun parseStar(line: String): Star {
    val (x, y, vx, vy) =
            Regex("position=<(-?\\d+),(-?\\d+)>velocity=<(-?\\d+),(-?\\d+)>")
                .matchEntire(line)!!
                .groupValues.drop(1) // 0 ist gesamter Match

    return Star(
        Position(x.toInt() to y.toInt()),
        Velocity(vx.toInt() to vy.toInt())
    )
}
