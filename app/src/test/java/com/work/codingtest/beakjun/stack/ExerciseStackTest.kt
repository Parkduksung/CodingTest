package com.work.codingtest.beakjun.stack

import org.junit.Assert.*
import org.junit.Test

class ExerciseStackTest {


    //exam1
    @Test
    fun `list 3,0,4,0 의 결과값은 0 이어야 한다`() {

        val list = listOf(3, 0, 4, 0)

        assertEquals(ExerciseStack.exam1(list), 0)
    }

    @Test
    fun `list 1,3,5,4,0,0,7,0,0,6 의 결과값은 7 이어야 한다`() {

        val list = listOf(1,3,5,4,0,0,7,0,0,6)

        assertEquals(ExerciseStack.exam1(list), 7)
    }


}