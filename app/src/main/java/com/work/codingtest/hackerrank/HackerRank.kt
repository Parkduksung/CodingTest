package com.work.codingtest.hackerrank

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


}