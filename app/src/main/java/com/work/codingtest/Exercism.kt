package com.work.codingtest

object Exercism {

    fun hello(): String {
        return "Hello, World!"
    }

    fun reverse(input: String): String = input.reversed()



    fun convert(n: Int): String {
        val getMultiplicationOfThree = when {
            n % 3 == 0 -> "Pling"
            else -> ""
        }
        val getMultiplicationOfFive = when {
            n % 5 == 0 -> "Plang"
            else -> ""
        }
        val getMultiplicationOfSeven = when {
            n % 7 == 0 -> "Plong"
            else -> ""
        }
        val toSum =
            getMultiplicationOfThree + getMultiplicationOfFive + getMultiplicationOfSeven
        if (toSum.isEmpty())
            return "$n"
        return toSum

        // p.s  buildString 으로도 해보는걸 추천.

    }
}