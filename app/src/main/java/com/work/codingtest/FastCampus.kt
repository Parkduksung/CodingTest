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


    // 1- 사칙 연산을 수행할 수 있는 클래스

    // 좀 대충한거같긴함..
    class Calculation(
        private val num1: Int,
        private val num2: Int
    ) {
        fun toAdd(): Int = num1 + num2
        fun toMin(): Int = num1 - num2
        fun toMul(): Int = num1 * num2
        fun toDiv(): Int = num1 / num2
    }


    // 2- 이행 계좌 만들기
    //계좌생성기능(이름,생년월일)
    //잔고를 확인하는기능
    //출금기능
    //예금기능

    data class Client(
        var name: String = "",
        var birthDay: String = "",
        var money: Int = 0
    )

    class MyAccount {
        //        private var money = 0
        private val client by lazy { Client() }

//        private lateinit var name: String
//        private lateinit var birthDay: String

        //아래 방식들보단 Model 만드는게 나은듯.
//        fun initAccount(name: String, birthDay: String) {
//            this.name = name
//            this.birthDay = birthDay
//        }
//
//        fun checkInformation(): Map<String, String> =
//            if (::name.isInitialized || ::birthDay.isInitialized) {
//                mapOf(Pair(name, birthDay))
//            } else {
//                emptyMap()
//            }
//
//        fun getAccountName(): String =
//            if (::birthDay.isInitialized) {
//                birthDay
//            } else {
//                ""
//            }
//        fun getAccountBirthDay(): String =
//            if (::name.isInitialized) {
//                name
//            } else {
//                ""
//            }

//        fun checkAccount(): Int = money
//
//        fun toDeposit(deposit: Int) {
//            money += deposit
//        }
//
//        fun toWithdrawal(withdrawal: Int) {
//            money -= withdrawal
//        }

        fun initAccount(name: String, birthDay: String) {
            client.name = name
            client.birthDay = birthDay
        }

        fun getClientInformation(): Client = client

        fun toDeposit(deposit: Int) {
            client.money += deposit
        }

        fun toWithdrawal(withdrawal: Int) {
            client.money -= withdrawal
        }
    }


}