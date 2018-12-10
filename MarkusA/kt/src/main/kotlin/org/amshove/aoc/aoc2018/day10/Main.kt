package org.amshove.aoc.aoc2018.day10

import kotlin.contracts.ExperimentalContracts

@ExperimentalContracts
fun main() {
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
}

fun createInitialSky(input: String) : Sky =
    input
    .split("\n")
    .filterNot { it.isEmpty() }
    .map(::parseStar)

private fun parseStar(line: String) : Star{
    val (x, y, vx, vy) = Regex("position=<(-?\\d+),(-?\\d+)>velocity=<(-?\\d+),(-?\\d+)>")
        .matchEntire(line.replace(" ", ""))!!
        .groupValues.drop(1) // 0 ist gesamter Match
    return Star(
        Position(x.toInt() to y.toInt()),
        Velocity(vx.toInt() to vy.toInt())
    )
}
