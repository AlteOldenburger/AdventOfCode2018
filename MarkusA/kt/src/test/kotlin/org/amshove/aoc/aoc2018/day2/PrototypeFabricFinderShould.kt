package org.amshove.aoc.aoc2018.day2

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

class PrototypeFabricFinderShould {

    @Test
    fun `find a similar subset of two ids`() {
        findSimilarBoxIds(listOf("fguij", "fguij")).shouldEqual("fgij")
    }
}