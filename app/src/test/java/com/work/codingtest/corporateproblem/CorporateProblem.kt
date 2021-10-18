package com.work.codingtest.corporateproblem

import org.junit.Test
import java.lang.Exception
import java.text.SimpleDateFormat
import kotlin.math.abs

class CorporateProblem {


    //1~10,000 사이의 정수를 1,000,000,000번 랜덤하게 입력 받을 경우,
    //각 정수가 몇개씩 입력 되었는지 확인할 수 있는 기능을 만들어 주세요.
    @Test
    fun `테스트1`() {
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

    //두 날짜 사이의 일수를 구하세요.
    @Test
    fun `테스트2`() {

        val date1 = "2016/09/21"
        val date2 = "2016/09/10"

        try {
            val simpleDateFormat = SimpleDateFormat("yyyy/mm/dd")

            val toConvertDate1 = simpleDateFormat.parse(date1)
            val toConvertDate2 = simpleDateFormat.parse(date2)

            val calDate = toConvertDate1.time - toConvertDate2.time

            val resultDays = abs(calDate / (24 * 60 * 60 * 1000))

            println(resultDays)

        } catch (e: Exception) {
            println(e)
        }

    }


}

