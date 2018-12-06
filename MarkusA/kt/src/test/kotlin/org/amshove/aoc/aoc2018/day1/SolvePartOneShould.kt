package org.amshove.aoc.aoc2018.day1

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

class SolvePartOneShould {
    private fun solve(vararg frequencies: Long) = solvePartOne(frequencies.toList())

    @Test
    fun `sum up two frequencies`() {
        solve(2L, 5L).shouldEqual(7L)
    }

    @Test
    fun `sum up a negative frequency`() {
        solve(2, -5).shouldEqual(-3L)
    }

    @Test
    fun `sum up negative frequencies`() {
        solve(-2, -5).shouldEqual(-7L)
    }

    @Test
    fun `sum up multiple frequencies`() {
        solve(-2, 7, 9, -98, -5).shouldEqual(-89L)
    }
}