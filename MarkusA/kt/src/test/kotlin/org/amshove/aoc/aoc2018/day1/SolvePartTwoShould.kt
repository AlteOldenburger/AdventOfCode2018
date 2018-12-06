package org.amshove.aoc.aoc2018.day1

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

class SolvePartTwoShould {
    private fun solve(vararg sequences: Long) = solvePartTwo(sequences.toList())

    @Test
    fun `find a duplicate without the need of cycling`() {
        solve(1, -1).shouldEqual(0)
    }

    @Test
    fun `find a duplicate with cycling`() {
        solve(3, 3, 4, -2, -4).shouldEqual(10)
        solve(-6, 3, 8, 5, -6).shouldEqual(5)
        solve(7, 7, -2, -7, -4).shouldEqual(14)
    }
}