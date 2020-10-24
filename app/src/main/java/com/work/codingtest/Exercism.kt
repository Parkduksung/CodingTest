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

    class CustomSet @JvmOverloads constructor(
        private val num1: Int? = null,
        private val num2: Int? = null,
        private val num3: Int? = null,
        private val num4: Int? = null
    ) {


        private var list =
            mutableListOf<Int>().apply {
                num1?.let { add(it) }
                num2?.let { add(it) }
                num3?.let { add(it) }
                num4?.let { add(it) }
            }

        fun isEmpty(): Boolean =
            list.isEmpty()


        fun isSubset(other: CustomSet): Boolean =
            other.list.containsAll(list)


        fun isDisjoint(other: CustomSet): Boolean {
            val _list = list
            val _otherList = other.list

            other.list.removeAll(_list)
            list.removeAll(_otherList)

            return other.list.isEmpty() || list.isEmpty() || other.list.size == list.size
        }

        fun contains(other: Int): Boolean {
            var result = false
            list.forEach { element ->
                if (element == other) {
                    result = true
                }
            }
            return result
        }

        fun intersection(other: CustomSet): CustomSet {
            return when {
                other.list.isEmpty() -> {
                    other
                }
                list.isEmpty() -> {
                    this
                }
                else -> {
                    val list = mutableListOf<Int>()
                    val customSet1 = CustomSet(num1, num2, num3, num4)

                    customSet1.list.forEach {
                        if (other.contains(it)) {
                            list.add(it)
                        }
                    }

                    val result = CustomSet()
                    result.list = list

                    return result
                }
            }
        }

        fun add(other: Int) {
            list.add(other)
        }

        override fun equals(other: Any?): Boolean =
            (other as CustomSet).list.containsAll(list) && list.containsAll(other.list)

        operator fun plus(other: CustomSet): CustomSet {
            val customSet =
                CustomSet(num1, num2, num3, num4)

            customSet.list.addAll(other.list)

            customSet.list.distinct()

            return customSet
        }

        operator fun minus(other: CustomSet): CustomSet {
            val customSet =
                CustomSet(num1, num2, num3, num4)

            customSet.list.removeAll(other.list)

            return customSet
        }
    }

    fun cryptoSquare(plaintext: String): String {

        val onlyText = plaintext.filter(Character::isLetterOrDigit).toLowerCase()

        if (onlyText.isEmpty()) {
            return onlyText
        }

        var searchCount = 0

        var isSquare = false
        var isNearSquare = false

        while (true) {
            if (searchCount * searchCount == onlyText.length) {
                isSquare = true
                break
            }
            if ((searchCount + 1) * (searchCount + 1) == onlyText.length) {
                isSquare = true
                searchCount++
                break
            }
            if ((searchCount * searchCount) < onlyText.length && onlyText.length < ((searchCount + 1) * (searchCount + 1))) {
                if (((searchCount + 1) * (searchCount + 1)) - onlyText.length < onlyText.length - (searchCount * searchCount)) {
                    isNearSquare = true
                }
                break
            }
            searchCount++
        }
        return if (isSquare) {
            matrixOperationToString(onlyText, searchCount, searchCount)
        } else {
            if (isNearSquare) {
                matrixOperationToString(onlyText, searchCount + 1, searchCount + 1)
            } else {
                matrixOperationToString(onlyText, searchCount, searchCount + 1)
            }
        }
    }

    private fun matrixOperationToString(inputText: String, row: Int, column: Int): String {
        val result = mutableListOf<String>()
        val reverseResult = mutableListOf<String>()
        var count = 0

        for (i in 0 until row) {
            var string = ""
            for (j in 0 until column) {
                if (count >= inputText.length) {
                    string += " "
                } else {
                    string += inputText[count]
                }
                count++
            }
            result.add(string)
        }
        for (i in 0 until column) {
            var string = ""
            for (j in 0 until row) {
                string += result[j][i]
            }
            reverseResult.add(string)
        }
        return reverseResult.joinToString(" ")
    }

//    fun isValid(number: String): Boolean {
////        for (i in number.indices) {
////            var char = number.get(i)
////            if (!char.isDigit() && char != '-' && char != 'X') {
////                return false
////            }
////            if (char == 'X' && i != number.length - 1) {
////                return false
////            }
////        }
////        var newNumber = number.replace("-", "")
////        if (newNumber.length != 10) {
////            return false
////        }
////        var resultSum = 0
////        newNumber.forEachIndexed { index, c ->
////            if (c == 'X') {
////                resultSum += (newNumber.length - index) * 10
////            } else {
////                resultSum += (newNumber.length - index) * c.toString().toInt()
////            }
////        }
////        return resultSum % 11 == 0
////    }

    fun isValid(number: String): Boolean {

        val convertString = number.replace(Regex("^[0-9X]"), "")

        return isCheckPositionX(convertString) and
                isCheckStringlength(convertString) and
                isMod(convertString)
    }


    private fun isCheckPositionX(string: String): Boolean =
        string[string.lastIndex] == 'X' && string.filter { it == 'X' }.count() == 1

    private fun isCheckStringlength(string: String): Boolean =
        string.length == 10

    private fun isMod(string: String): Boolean {
        var resultSum = 0
        string.forEachIndexed { index, c ->
            if (c == 'X') {
                resultSum += (string.length - index) * 10
            } else {
                resultSum += (string.length - index) * c.toString().toInt()
            }
        }
        return resultSum % 11 == 0
    }
}

