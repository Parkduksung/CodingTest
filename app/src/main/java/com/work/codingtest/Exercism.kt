package com.work.codingtest

import kotlin.math.pow
import kotlin.math.sqrt

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

    fun dart(x: Number, y: Number /* choose proper types! */): Int {

        val SQUARE_NUMBER = 2

        val distanceFromOrigin =
            sqrt(x.toDouble().pow(SQUARE_NUMBER) + y.toDouble().pow(SQUARE_NUMBER))

        when {
            distanceFromOrigin <= 1 -> {
                return 10
            }

            1 < distanceFromOrigin && distanceFromOrigin <= 5 -> {
                return 5
            }

            5 < distanceFromOrigin && distanceFromOrigin <= 10 -> {
                return 1
            }

            else -> {
                return 0
            }

        }
    }

    // 문제 파악이 잘 안됬었음...
    // Atomic , ConcurrentQueue 사용해보기..
    class BankAccount {
        private var _balance = 0L
        private var isClosed = false

        val balance: Long
            get() {
                if (isClosed) throw IllegalStateException()
                return _balance
            }

        fun adjustBalance(amount: Long) {
            if (isClosed) throw IllegalStateException()
            //동기화 시켜주는거임.
            synchronized(this) {
                _balance += amount
            }
        }

        fun close() {
            isClosed = true
        }
    }

    fun wordy(input: String): Int {
        val startString = "What is"
        val endString = "?"


        val coreSentence = input.substring(startString.length, input.length - endString.length)

        val transformCoreSentence = coreSentence // removing question mark
            .replace("multiplied by", "multiple")
            .replace("divided by", "divide")
            .replace("raised to the", "pow")
            .replace("th power", "")
            .replace("st power", "")
            .replace("nd power", "")
            .split(" ")
            .dropWhile { it.all { char -> !char.isDigit() } }
            .toMutableList()


        var result = transformCoreSentence.removeAt(0).toInt()

        while (transformCoreSentence.isNotEmpty()) {
            val operator = transformCoreSentence.removeAt(0)
            val num = transformCoreSentence.removeAt(0).toInt()

            result = when (operator) {
                "plus" -> result.plus(num)
                "minus" -> result.minus(num)
                "multiple" -> result.times(num)
                "divide" -> result.div(num)
                "pow" -> result.toDouble().pow(num.toDouble()).toInt()
                else -> throw IllegalArgumentException()
            }
        }
        return result
    }
}