package com.work.codingtest

import java.util.*

object Lv1 {

    //이문제 맞추고 풀이들 보니까 import java.util.* 안해서 풀었는데 나중에 그렇게도 풀어볼것.
    fun _2016(month: Int, day: Int): String {

        val calendar = Calendar.getInstance()
        calendar.set(2016, month - 1, day)

        return when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> {
                "MON"
            }
            Calendar.TUESDAY -> {
                "TUE"
            }
            Calendar.WEDNESDAY -> {
                "WED"
            }
            Calendar.THURSDAY -> {
                "THU"
            }
            Calendar.FRIDAY -> {
                "FRI"
            }
            Calendar.SATURDAY -> {
                "SAT"
            }
            Calendar.SUNDAY -> {
                "SUN"
            }
            else -> {
                ""
            }
        }
//        val calendar = Calendar.getInstance()
//        calendar.set(2016, month - 1, day)
//
//        return when (SimpleDateFormat("EEEE").format(calendar.time)) {
//            "Monday" -> {
//                "MON"
//            }
//            "Tuesday" -> {
//                "TUE"
//            }
//            "Wednesday" -> {
//                "WED"
//            }
//            "Thursday" -> {
//                "THU"
//            }
//            "Friday" -> {
//                "FRI"
//            }
//            "Saturday" -> {
//                "SAT"
//            }
//            "Sunday" -> {
//                "SUN"
//            }
//            else -> {
//                ""
//            }
//        }
    }

    fun reverseArray(n: Long): IntArray {

        val list = mutableListOf<Int>()

        n.toString().forEach {
            list.add(it.toInt() - 48)
        }

        list.reverse()

        return list.toIntArray()

//        아래 방법이 더 나은듯..
//        n.toString().reversed().map { it.toString().toInt() }.toIntArray()
    }

    fun descendingOrder(n: Long): Long {

        //위에문제 영감을 받아서 접목시켜봄.
        var answer = ""

        n.toString().map { it.toString().toInt() }.sortedDescending().forEach {
            answer += it
        }
        return answer.toLong()


//        joinToString 같은 join은 list를 하나의 변수로 합치는데 도움을 주겠군..
//        n.toString().map { it.toString().toInt() }.sortedDescending().joinToString { "" }.toLong()

    }

}