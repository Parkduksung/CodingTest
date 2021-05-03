package com.work.codingtest.beakjun.stack

import java.util.*


object ExerciseStack {


    //출처 : https://www.acmicpc.net/problem/10773
    fun exam1(list: List<Int>): Int {

        val stack = Stack<Int>()

        list.forEach { num ->
            if (num == 0) {
                stack.pop()
            }else{
                stack.push(num)
            }
        }

        return stack.sum()
    }

}