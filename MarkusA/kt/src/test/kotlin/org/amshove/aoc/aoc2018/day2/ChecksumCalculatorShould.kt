package org.amshove.aoc.aoc2018.day2

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

class ChecksumCalculatorShould {

    private fun checksumOf(vararg boxIds: String) = calculateChecksum(boxIds.toList())

    @Test
    fun `calculate a checksam based on a single input`() {
        checksumOf("bababc").shouldEqual(1)
    }

    @Test
    fun `calculate a checksum based on two inputs`() {
        checksumOf("bababc", "abcccd").shouldEqual(2)
    }

    @Test
    fun `calculate a checksum based on example input`() {
        val boxIds = listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")
        calculateChecksum(boxIds).shouldEqual(12)
    }
}