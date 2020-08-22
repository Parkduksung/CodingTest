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

    fun transpose(input: List<String>): List<String> {
        return when {
            input.size == 1 -> {
                input[0].map { it.toString() }
            }
            input.size > 1 -> {
                val list = mutableListOf<String>()

                val maxLengthStringOfList = input.map { it.length }.max()

                maxLengthStringOfList?.let {
                    for (i in 0 until maxLengthStringOfList) {
                        var toResultString = ""

                        input.forEachIndexed { indexString, s ->
                            s.forEachIndexed { indexChar, c ->
                                if (indexChar == i) {
                                    toResultString += c
                                }
                            }
                        }
                        list.add(toResultString)
                    }
                }

                list

            }
            else -> {
                emptyList()
            }
        }
    }
}