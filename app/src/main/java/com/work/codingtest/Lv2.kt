package com.work.codingtest

import java.util.*

object Lv2 {

    //오래 걸릴게 아닌데..ㅜ
    fun top(heights: IntArray): IntArray {
        val resultArray = mutableListOf<Int>()

        for (i in 0 until heights.size) {
            var toggle = 0

            for (j in 1 + i until heights.size) {
                if (heights[heights.size - 1 - i] < heights[heights.size - 1 - j] && toggle == 0) {
                    resultArray.add(heights.size - j)
                    toggle += 1
                }
            }

            if (toggle == 0)
                resultArray.add(0)
        }
        return resultArray.toIntArray().reversedArray()
    }

    //피보 오랜만인데 처음 코틀린스럽게 풀어서 정답이라 생각했는데 메모리 측면에서 %1234567하는건 알겠는데
    //개인적으로는 문제 자체가 정확하게 명시해주지 않아서 오래걸렸다..
    fun pibo(n: Int): Int {
//        return when (n % 1234567) {
//            0 -> 0
//            1 -> 1
//            else -> pibo(n - 1) + pibo(n - 2)
//        }

        if (n == 1 || n == 2) return 1
        var n1 = 1
        var n2 = 1
        var sum = 0 // @2
        for (i in 3..n) { // @3
            sum = n1 + n2
            sum %= 1234567
            n1 = n2
            n2 = sum
        }
        return sum
    }

    // 사실 좀더 간단하게 하려면 음.
    // s.split(" ").map { it.toInt() }.let { "${it.min()} ${it.max()}" }
    // 이게 좀더 코틀린 냄새남.
    fun maxNumAndMinNum(s: String): String =
        "${s.split(" ").map { it.toInt() }.min()} ${s.split(" ").map { it.toInt() }.max()}"


    //map의 key값이 중복이 안된다는걸 알게 된 문제 value값은 중복가능...
    //https://codediver.tistory.com/49 참고할것.
    //mutableList에서 remove시켜주고나서 값 toList해주면 문제가 풀리는데 그렇지 않으면 답은 다 맞긴한데 왜 안되는거지...ㅜ
    fun functionalDevelopment(progresses: IntArray, speeds: IntArray): IntArray {

        val array = mutableListOf<Int>()

        for (i in 0 until progresses.size) {
            var count = 1
            while (true) {
                if (progresses[i] + speeds[i] * count >= 100) {
                    array.add(count)
                    break
                }
                count++
            }
        }

        val resultArray = mutableListOf<Int>()

        var count = 0
        var sameNum = 1
        while (true) {
            if (array.size - 1 == resultArray.size) {
                resultArray.add(sameNum)
                break
            } else {
                if (array[count] >= array[count + 1]) {
                    sameNum += 1
                    array.removeAt(count + 1)
                    array.toList()
                } else {
                    resultArray.add(sameNum)
                    sameNum = 1
                    count += 1
                }
            }
        }
        return resultArray.toIntArray()
    }


    //FIFO 방식인건 바로 눈치챘는데 이걸 표현하는데 좀 걸렸네
    //val queueList: Queue<Int> = LinkedList() 이거 사용법이 중요할듯
    fun bridge(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {

        var resultCount = 0
        val queueList: Queue<Int> = LinkedList()


        truck_weights.forEachIndexed { index, it ->

            while (true) {
                resultCount++

                if (queueList.size < bridge_length) {
                    if (it + queueList.sum() <= weight) {
                        queueList.add(it)
                        break
                    } else {
                        queueList.add(0)
                    }
                } else {
                    queueList.remove()
                    if (it + queueList.sum() <= weight) {
                        queueList.add(it)
                        break
                    } else {
                        queueList.add(0)
                    }
                }
            }

            if (index == truck_weights.lastIndex) {
                while (true) {
                    resultCount++

                    if (queueList.size < bridge_length) {
                        queueList.add(0)
                    } else {
                        queueList.remove()

                        if (queueList.sum() == 0) {
                            break
                        } else {
                            queueList.add(0)
                        }
                    }
                }
            }
        }
        return resultCount
    }

}
