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

        val list = listOf(1, 3, 5, 4, 0, 0, 7, 0, 0, 6)

        assertEquals(ExerciseStack.exam1(list), 7)
    }


    //exam2
    @Test
    fun `list (())()) 의 결과값은 No 이어야 한다`() {

        var list = "(())())"

        assertEquals(ExerciseStack.exam2(list), false)

        list = "(((()())()"

        assertEquals(ExerciseStack.exam2(list), false)

        list = "(()())((()))"

        assertEquals(ExerciseStack.exam2(list), true)

        list = "((()()(()))(((())))()"

        assertEquals(ExerciseStack.exam2(list), false)

        list = "()()()()(()()())()"

        assertEquals(ExerciseStack.exam2(list), true)

        list = "(()((())()("

        assertEquals(ExerciseStack.exam2(list), false)

        list = "(("

        assertEquals(ExerciseStack.exam2(list), false)

        list = "))"

        assertEquals(ExerciseStack.exam2(list), false)

        list = "())(()"

        assertEquals(ExerciseStack.exam2(list), false)
    }

    //exam3
    @Test
    fun `각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다`() {

        var string = "So when I die (the [first] I will see in (heaven) is a score list)."

        assertEquals(ExerciseStack.exam3(string), true)

        string = "[ first in ] ( first out )."

        assertEquals(ExerciseStack.exam3(string), true)

        string = "Half Moon tonight (At least it is better than no Moon at all]."

        assertEquals(ExerciseStack.exam3(string), false)

        string = "A rope may form )( a trail in a maze."

        assertEquals(ExerciseStack.exam3(string), false)

        string = "Help( I[m being held prisoner in a fortune cookie factory)]."

        assertEquals(ExerciseStack.exam3(string), false)

        string = "([ (([( [ ] ) ( ) (( ))] )) ])."

        assertEquals(ExerciseStack.exam3(string), true)

        string = " ."

        assertEquals(ExerciseStack.exam3(string), true)

    }

    //exam4
    @Test
    fun `쇠막대기`() {

        var string = "()(((()())(())()))(())"

        assertEquals(ExerciseStack.exam4(string), 17)

        string = "(((()(()()))(())()))(()())"

        assertEquals(ExerciseStack.exam4(string), 24)

    }


}