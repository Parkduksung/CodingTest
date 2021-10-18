package com.work.codingtest.corporateproblem

import org.junit.Test

class CorporateProblem {


    //1~10,000 사이의 정수를 1,000,000,000번 랜덤하게 입력 받을 경우,
    //각 정수가 몇개씩 입력 되었는지 확인할 수 있는 기능을 만들어 주세요.
    @Test
    fun `테스트1`(){
        val resultMap = HashMap<Int, Int>()

        for (i in 0 until 100000000) {
            val randomKey = (1..10000).random()

            if (resultMap.containsKey(randomKey)) {
                resultMap[randomKey]?.let { value ->
                    resultMap.replace(
                        randomKey,
                        value,
                        value + 1
                    )
                }
            } else {
                resultMap[randomKey] = 0
            }
        }

        for ((key, value) in resultMap) {
            println("index $key 횟수 : $value")
        }
        println("resultMap Size 값 :" + resultMap.size.toString())
    }
}