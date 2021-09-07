package com.work.codingtest.hackerrank

import java.util.*

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

}