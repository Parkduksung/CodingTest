package com.work.codingtest.beakjun.stack

import java.util.*


object ExerciseStack {


    //출처 : https://www.acmicpc.net/problem/10773
    fun exam1(list: List<Int>): Int {

        val stack = Stack<Int>()

        list.forEach { num ->
            if (num == 0) {
                stack.pop()
            } else {
                stack.push(num)
            }
        }

        return stack.sum()
    }


    //출처 : https://www.acmicpc.net/problem/9012
    fun exam2(list: String): Boolean {

        val stack = Stack<Char>()

        list.forEach {
            if (it == '(') {
                stack.push(it)
            } else {
                try {
                    stack.pop()
                } catch (e: Exception) {
                    return false
                }
            }
        }
        return !(stack.contains('(') || stack.contains(')'))
    }


    //출처 : https://www.acmicpc.net/problem/4949
    fun exam3(string: String): Boolean {

        val stack = Stack<Char>()

        string.forEach {
            if (it == '(' || it == '[') {
                stack.push(it)
            } else if (it == ')') {
                try {
                    if (stack.peek() == '(') {
                        stack.pop()
                    } else {
                        stack.push(it)
                    }
                } catch (e: Exception) {
                    return false
                }
            } else if (it == ']') {
                try {
                    if (stack.peek() == '[') {
                        stack.pop()
                    } else {
                        stack.push(it)
                    }
                } catch (e: Exception) {
                    return false
                }
            }
        }


        return !(stack.contains('(') || stack.contains(')') ||
                stack.contains('[') || stack.contains(']'))
    }


    //출처 : acmicpc.net/problem/10799
    fun exam4(string: String): Int {

        val stack = Stack<Char>()

        var count = 0

        string.forEachIndexed { index, c ->
            if (c == '(') {
                stack.push(c)
            } else {
                stack.pop()
                count += if (string[index - 1] == '(') {
                    stack.size
                } else {
                    1
                }
            }
        }
        return count
    }

}