package org.amshove.aoc.aoc2018.day2

private fun String.differentLetters(to: String) =
    this.mapIndexed { index, id -> this[index] == to[index] }
        .count { isSame -> !isSame }

private fun String.withDifference(to: String) =
    this.mapIndexed { index, letter -> if (this[index] != to[index]) index else null }
        .filterNotNull()
        .first()
        .let { diffedIndex ->
            this.substring(0..diffedIndex) + this.substring(diffedIndex + 1)
        }

fun asd(boxIds: Iterable<String>) =
    boxIds
        .map { testedBoxId ->
            boxIds.filter { testedAgainstId ->
                testedBoxId.differentLetters(testedAgainstId) == 1
            }
        }
        .flatten()
        .take(2)
        .let { it[0].withDifference(it[1]) }

fun main(args: Array<String>) {
    println(asd(INPUT))
    // Falsch. Hab eine BoxId gesucht die nur einen Unterschied zu einer anderen hat.
    // Gesucht ist die Id ohne den unterschiedlichen Buchstaben
}