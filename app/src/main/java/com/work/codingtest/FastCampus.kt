package com.work.codingtest

object FastCampus {
    //1번문제
    //List 를 두개 만든다
    //첫번째 List 에는 0부터 9까지 값을 넣는다
    //(반복문사용)
    //두번째 List 에는 첫번째 List 의 값을 하나씩 확인한 후 짝수면 True 홀수면 False 를 넣어준다.

    fun quiz1() {
        val list1 = mutableListOf<Int>()
        for (i in 0..9)
            list1.add(i)
        val list2 = list1.map { it % 2 == 0 }
    }

    //
    //2번문제
    //학점을 구하자
    //80 - 90 -> A
    //70 - 79 -> B
    //60 - 69 -> C
    //else -> F


    //3번 문제
    //전달 받은 숫자의 각 자리 수의 합을 구하자 조건: 전달받은 숫자는 무조껀 두자리 숫자이다.

    //4번 문제
    //구구단출력

}