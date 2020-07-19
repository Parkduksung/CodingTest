package com.work.codingtest

import android.util.Log

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

        list1.forEach {
            Log.d("결과-list1", "$it")
        }

        val list2 = list1.map { it % 2 == 0 }

        list2.forEach {
            Log.d("결과-list2", "$it")
        }
    }

    //
    //2번문제
    //학점을 구하자
    //80 - 90 -> A
    //70 - 79 -> B
    //60 - 69 -> C
    //else -> F


    // 문제가 좀 이상하네.. 그러면 90점이상은 F가 되는데 이건 고려한 문제는 아니네..
    // 그리고 만점이 정해져 있지 않다. 기본적인 상식이 100점 만점이겠지만 그렇지 않았을때는? 문제 좀 이상함
    fun quiz2(score: Int): String =
        when (score) {
            //type1
            in 80..90 -> {
                "A"
            }
            //type2
            in IntRange(70, 79) -> {
                "B"
            }
            // type3 사실 2하고 다른건 없는데 이런식으로 res 에 관리해두면 편리하지 않을까해서
            in RANGE_C -> {
                "C"
            }
            else -> {
                "F"
            }
        }

    private val RANGE_C = IntRange(60, 69)


    //3번 문제
    //전달 받은 숫자의 각 자리 수의 합을 구하자 조건: 전달받은 숫자는 무조껀 두자리 숫자이다.

    // 처음엔 그리고 예전에도 그랬지만 나머지나 몫을 가지고 루프를 돌려 접근했엇는데
    // 아래 방식이 갑자기 떠오름.
    fun quiz3(num: Int) =
        num.toString().map { it.toString().toInt() }.sum()


    //4번 문제
    //구구단출력
    fun quiz4() {
        // 기본적인 방식
        for (i in 1..9) {
            for (j in 1..9) {
                Log.d("$i x $j", "${i * j}")
            }
        }
    }

}