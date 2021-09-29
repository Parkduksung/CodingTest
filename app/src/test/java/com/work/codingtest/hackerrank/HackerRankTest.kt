package com.work.codingtest.hackerrank

import android.util.Log
import com.work.codingtest.hackerrank.HackerRank.calc
import com.work.codingtest.hackerrank.HackerRank.game369
import com.work.codingtest.hackerrank.HackerRank.stringExam
import com.work.codingtest.hackerrank.HackerRank.total
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

    @Test
    fun Test() {

        val string = "1 3\n2 6\n8 10\n15 18"

        val stringList1 =
            string.split("\n").map { it.split(" ") }

        val stringList2 =
            stringList1.map { IntRange(it[0].toInt(), it[it.lastIndex].toInt()) }



        stringList1.forEach {
            println(it)
        }

        val resultList = mutableListOf<String>()

        for (i in stringList2.indices) {

            if (i + 1 < stringList2.lastIndex) {

                if (stringList2[i + 1].first < stringList2[i].last) {
                    resultList.add("[${stringList2[i].first}-${stringList2[i + 1].last}]")
                } else {
                    resultList.add("[${stringList2[i].first}-${stringList2[i].last}]")
                }
            }
        }

        println(resultList)

//        stringList2[0].last
//
//        println(stringList2[0].contains(stringList2[0]))
//
//
//        stringList2.forEach {
//            println(it)
//        }

    }


    @Test
    fun stringExamTest() {

        val list = arrayOf("mijoo lee", "JIAE Yoo", "jiSOO seo")

        stringExam(list).forEach {
            println(it)
        }

    }

    @Test
    fun calcTest() {

        var result = calc(HackerRank.RatioChat.USD, HackerRank.RatioChat.KRW)

        println(result)

        result = calc(HackerRank.RatioChat.EUR, HackerRank.RatioChat.KRW)

        println(result)

        result = calc(HackerRank.RatioChat.JPY, HackerRank.RatioChat.CAD)

        println(result)
    }

    @Test
    fun totalTest() {

        println(total("78 90 85"))

    }

    @Test
    fun game369Test() {
//        println(game369(13))

        println(Exam().game369ToJava(13))
    }
}