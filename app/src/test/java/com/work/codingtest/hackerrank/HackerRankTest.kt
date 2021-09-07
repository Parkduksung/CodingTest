package com.work.codingtest.hackerrank

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class HackerRankTest {

    @Test
    fun fizzbuzz() {
        for (i in 1..15) {
            HackerRank.fizzbuzz(i)
        }
    }

    @Test
    fun bracesTest() {

        val array = arrayOf("{}[]()", "{[}]", "}")

        val result = arrayOf("YES", "NO", "NO")

        assertArrayEquals(HackerRank.braces(array), result)

    }

    @Test
    fun programmerStringsTest() {

        val mockData = "programmerttprogrammer"

        assertEquals(HackerRank.programmerStrings(mockData), 2)

    }

    @Test
    fun countTeamsTest() {

        assertEquals(HackerRank.countTeams(arrayOf(12, 4, 6, 13, 5, 10), 3, 4, 10), 5)

    }
}