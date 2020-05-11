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

    //맞긴 맞았는데 제한조건인 100,000,000 이하의 범위서의 자연수만 가능하게 해줬어야 된거같다..
    // int 형의 범위가 -2,147,483,648 ~ 2,147,483,647 이니까
    // 딴얘기지만 0을 자연수냐 아니냐 페노아공리때문에 포함시키는 자도 있다고 한다.
    // 교육받을때 1부터라 배웠으니 그냥 그렇게 생각하면 상관은 없지만 자연수의 범위를 검색하다가 발견해서..
    fun plusDigits(n: Int): Int =
        n.toString().map { it.toString().toInt() }.sum()

    fun strangeString(s: String): String {

        var result = ""
        var count = 0

        s.forEach {
            when {
                it == ' ' -> {

                    count = 0
                    result += " "
                }

                count % 2 == 0 -> {
                    result += it.toUpperCase()
                    count++
                }

                else -> {
                    result += it.toLowerCase()
                    count++
                }
            }
        }
        return result

// 다른사람풀이중 이게 제일 신선.. 나머지는 다 내꺼랑 동일하네..
//        s.split(" ").joinToString(" ") { word ->
//            word
//                .mapIndexed { index, char ->
//                    if (index % 2 == 0) char.toUpperCase() else char.toLowerCase()
//                }
//                .joinToString("")
//        }
    }

    fun sumOfDivisor(n: Int): Int {

        var sum = 0

        for (i in 1..n) {
            if (n % i == 0)
                sum += i
        }

        return sum

        // 좀더 코틀린스러운 답.
        //(1..n).filter { n % it == 0 }.sum()
    }

    //다 비슷비슷한거같음.
    fun siGerCode(s: String, n: Int): String =
        s.map {
            when (it.toInt()) {
                in 65..90 -> {
                    if (it.toInt() + n > 90) {
                        (it.toInt() + n - 26).toChar()
                    } else {
                        (it.toInt() + n).toChar()
                    }
                }

                in 97..122 -> {
                    if (it.toInt() + n > 122) {
                        (it.toInt() + n - 26).toChar()
                    } else {
                        (it.toInt() + n).toChar()
                    }
                }
                else -> {
                    it
                }
            }
        }.joinToString("")

    fun suBak(n: Int): String {

        var result = ""

        if (n % 2 == 0) {
            for (i in 0 until n / 2)
                result += "수박"
        } else {

            for (i in 0 until n / 2)
                result += "수박"

            result += "수"
        }

        return result

//        이거 좋다..
//        return "수박".repeat(n / 2) + if (n % 2 != 0) "수" else ""
    }

    fun findKim(seoul: Array<String>): String {

//        이게 더 의미가 확실한듯.
//        seoul.indexOf("Kim")
        var num = 0

        seoul.filterIndexed { index, s ->
            if (s == "Kim") {
                num = index
            }
            false
        }
        return "김서방은 ${num}에 있다"
    }

    //다 비슷한데 짧게 했을뿐..
    fun dealWithString(s: String): Boolean =
        (s.length == 4 || s.length == 6) && ((s.toIntOrNull()) != null)

    //이런 구조도 사용 가능하구나...
//    return when (s.length) {
//        4, 6 -> true
//        else -> false
//    }
//    && when (s.toIntOrNull()) {
//        null -> false
//        else -> true
//    }

    //String(s.toCharArray().sortedArrayDescending()) 이것도 좋은듯.
    fun descendingText(s: String): String =
        s.map { it }.sortedDescending().joinToString("")


    fun myStyleArray(strings: Array<String>, n: Int): Array<String> =
        strings.map { it }.sorted().sortedBy { it[n] }.toTypedArray()
    // 먼가 아래가 더 깔끔하다.(맵과 형변환이 필요 없으니..)
//        strings.also {
//            it.sorted()
//            it.sortBy { it[n] }
//        }

    fun sumOfBetweenTwoInt(a: Int, b: Int): Long {
        var sum = 0L
        when {

            a > b -> {
                for (i in b..a)
                    sum += i
            }

            b > a -> {
                for (i in a..b)
                    sum += i
            }
            b == a -> {
                sum += a
            }
        }
        return sum
//      깔끔한듯 싶다.  그리고 max(a, b) 요런거 알아두면 더 좋을듯 min(a,b)랑.
//        val start : Long = (if(a>b) b else a).toLong()
//        val end : Long = (if(a>b) a else b).toLong()
//        return (start..end).sum()
    }

    fun divideNum(arr: IntArray, divisor: Int): IntArray {
        //먼가 한줄로 줄일수도 있을꺼같은데..
        return if (arr.filter { it % divisor == 0 }.map { it }.sorted().toIntArray().isEmpty()) {
            arrayOf(-1).toIntArray()
        } else {
            arr.filter { it % divisor == 0 }.map { it }.sorted().toIntArray()
        }

        //코틀린스러운듯.. 아래 답이 제일 다른 풀이중에서 제일 인상깊네. 다 돌아가거나 나랑 같은생각인데.
//        arr.filter { it % divisor == 0 }.sortedBy { it }.let
//        {
//            if (it.isEmpty()) intArrayOf(-1)
//            else it.toIntArray()
//        }
    }

    fun getMiddleText(s: String): String {
        return if (s.length % 2 == 1) {
            s.substring(s.length / 2, s.length / 2 + 1)
        } else {
            s.substring(s.length / 2 - 1, s.length / 2 + 1)
        }
    }

    //    with(s) { substring(length / 2 - 1 + (length % 2) .. length / 2) } 천재아니냐..?
//    생각해보면 짝수는 홀수든 상관은 없다고 이해되는데 처음생각하기엔 좀 어려울수도...


    fun numberK(array: IntArray, commands: Array<IntArray>): IntArray =
        commands.map {
            array.slice(
                IntRange(
                    it[0] - 1,
                    it[1] - 1
                )
            ).sorted()[it[2] - 1]
        }.toIntArray()
    // 아래같이 풀어서 맞췄는데 위에 답으로 좀더 간출여 봤음.
//        val resultArray = mutableListOf<Int>()
//
//        commands.forEach {
//           resultArray.add( array.slice(IntRange(it[0]-1,it[1]-1)).sorted()[it[2]-1])
//        }
//        return resultArray.toIntArray()


//    fun workoutClothes(n: Int, lost: IntArray, reserve: IntArray): Int {
//
//
//        reserve.filter { !lost.contains(it) }.map { it }
//
//
//    }

    //너무 오래걸림.. 스택이란 개념을 캐치하고나서 바로풀긴했는데..
    //아래 풀이를 참고해서 스택관련 공부좀 해야될듯..
//    var answer = 0
//    val stack = Stack<Int>()
//
//    moves.forEach {
//        for (i in board.indices) {
//            if (board[i][it - 1] != 0) {
//                if (stack.isNotEmpty() && stack.peek() == board[i][it - 1]) {
//                    answer += 2
//                    stack.pop()
//                } else {
//                    stack.push(board[i][it - 1])
//                }
//                board[i][it - 1] = 0
//
//                break
//            }
//        }
//    }
//    return answer
    fun carain(board: Array<IntArray>, moves: IntArray): Int {

        val resultArray = mutableListOf<Int>()

        moves.forEach { count ->
            var t = 0
            board.map { it[count - 1] }.forEachIndexed { index, i ->
                if (i != 0 && t == 0) {
                    resultArray.add(i)
                    t++
                    board[index][count - 1] = 0
                }
            }
        }

        val popArray = mutableListOf<Int>()

        resultArray.forEach {
            if (popArray.size == 0) {
                popArray.add(it)
            } else {
                if (popArray[popArray.lastIndex] == it) {
                    popArray.removeAt(popArray.lastIndex)
                } else {
                    popArray.add(it)
                }
            }
        }
        return resultArray.size - popArray.size
    }


}
