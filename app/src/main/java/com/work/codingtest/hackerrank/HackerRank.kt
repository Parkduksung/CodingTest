package com.work.codingtest.hackerrank

import java.util.*
import kotlin.math.round

object HackerRank {

    fun fizzbuzz(n: Int) {

        when {
            n % 3 == 0 && n % 5 != 0 -> {
                println("Fizz")
            }

            n % 5 == 0 && n % 3 != 0 -> {
                println("Buzz")
            }

            n % 3 == 0 && n % 5 == 0 -> {
                println("FizzBuzz")
            }

            else -> {
                println(n)
            }
        }
    }

    fun braces(values: Array<String>): Array<String> {
        val resultList = mutableListOf<String>()


        values.forEach { string ->

            val stack = Stack<Char>()

            stack.isNotEmpty()
            string.forEach {
                if (it == '(' || it == '[' || it == '{') {
                    stack.push(it)
                } else if (it == ')') {
                    try {
                        if (stack.peek() == '(') {
                            stack.pop()
                        } else {
                            stack.push(it)
                        }
                    } catch (e: Exception) {
                        stack.push(it)
                    }
                } else if (it == ']') {
                    try {
                        if (stack.peek() == '[') {
                            stack.pop()
                        } else {
                            stack.push(it)
                        }
                    } catch (e: Exception) {
                        stack.push(it)
                    }
                } else if (it == '}') {
                    try {
                        if (stack.peek() == '{') {
                            stack.pop()
                        } else {
                            stack.push(it)
                        }
                    } catch (e: Exception) {
                        stack.push(it)
                    }
                }
            }

            if (!(stack.contains('(') || stack.contains(')') || stack.contains('{') || stack.contains(
                    '}'
                ) || stack.contains('[') || stack.contains(']'))
            ) {
                resultList.add("YES")
            } else {
                resultList.add("NO")
            }
        }

        return resultList.toTypedArray()
    }

    fun programmerStrings(s: String): Int {

        var start = 0

        var end = 0

        val stringProgrammer = "programmer"

        val queue: Queue<Char> = LinkedList<Char>()

        stringProgrammer.forEach {
            queue.add(it)
        }

        s.forEachIndexed { index, char ->

            if (queue.isNullOrEmpty()) {
                if (char == 'p') {
                    end = index
                    return@forEachIndexed
                }
            } else {
                if (queue.peek() == char) {
                    queue.poll()

                    if (queue.isEmpty()) {
                        start = index + 1
                    }
                }
            }
        }

        return end - start
    }

    fun countTeams(skills: Array<Int>, minPlayers: Int, minLevel: Int, maxLevel: Int): Int {

        val rangeLevel = IntRange(minLevel, maxLevel)

        val containLevelPlayerList = skills.filter { i -> i in rangeLevel }

        var result = 0

        for (i in minPlayers..containLevelPlayerList.size) {
            result += factorialLoop(containLevelPlayerList.size) / (factorialLoop(i) * factorialLoop(
                (containLevelPlayerList.size - i)
            ))
        }

        return result;

    }

    private fun factorialLoop(n: Int): Int {
        var acc = 1
        for (number in 1..n) {
            acc *= number
        }
        return acc
    }


    fun stringExam(array: Array<String>): Array<String> {

        val t = array.map { item ->
            item.toLowerCase().split(" ").joinToString(" ") { string ->
                string[0].toUpperCase() + string.substring(1)
            }
        }
        return t.toTypedArray()
    }


    fun calc(from: RatioChat, to: RatioChat): Double {
        return round(((1.0 / from.ratio) * to.ratio) * 100) / 100
    }

    enum class RatioChat(val ratio: Double) {

        USD(1.0),

        EUR(0.8520),

        GBP(0.7211),

        JPY(106.57),

        CHF(0.9455),

        CAD(1.2127),

        AUD(1.3333),

        KRW(1156.35)

    }

    fun total(inputScore: String) {
        val toSplitInputScore = inputScore.split(" ").map { it.toInt() }

        val sumScore = toSplitInputScore.sum()
        val averageScore = (round(toSplitInputScore.average() * 100) / 100).toInt()

        val gradeAndMoney =
            when (averageScore) {
                in LongRange(90, 100) -> {
                    "A+ 1000000"
                }

                in 80 until 90 -> {
                    "A 800000"
                }

                in 70 until 80 -> {
                    "B+ 600000"
                }

                in 60 until 70 -> {
                    "B 400000"
                }

                else -> {
                    "F 0"
                }
            }
        println("$sumScore $averageScore $gradeAndMoney")
    }

    fun game369(num: Int): Int {

        var result = 0

        for (i in 1..num) {
            result += checkContain369(i)
        }

        return result
    }

    private fun checkContain369(num: Int): Int {

        var containCount = 0

        num.toString().map { it.toString().toInt() }.forEach { num ->
            if (num == 3 || num == 6 || num == 9) {
                containCount++
            }
        }
        return containCount
    }

}
