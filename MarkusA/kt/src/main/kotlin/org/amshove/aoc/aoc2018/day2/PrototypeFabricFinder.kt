package org.amshove.aoc.aoc2018.day2

private fun String.differentLetters(to: String) =
    this.mapIndexed { index, id -> this[index] == to[index] }
        .count { isSame -> !isSame }

fun asd(boxIds: Iterable<String>) =
    boxIds
        .map { testedBoxId ->
            boxIds.filter { testedAgainstId ->
                testedBoxId.differentLetters(testedAgainstId) == 1
            }
        }
        .flatten()
        .first()

fun main(args: Array<String>) {
    println(asd(INPUT))
    // Falsch. Hab eine BoxId gesucht die nur einen Unterschied zu einer anderen hat.
    // Gesucht ist die Id ohne den unterschiedlichen Buchstaben
}