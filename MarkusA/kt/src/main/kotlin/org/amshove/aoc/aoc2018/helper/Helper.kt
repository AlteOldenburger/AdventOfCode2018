package org.amshove.aoc.aoc2018.helper

fun <T> List<T>.cycle() = sequence {
    if (this@cycle.isEmpty()) return@sequence;
    while (true) {
        yieldAll(this@cycle)
    }
}
