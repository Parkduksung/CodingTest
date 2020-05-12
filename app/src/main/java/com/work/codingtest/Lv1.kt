package com.work.codingtest

import java.lang.Math.max
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


    //너무 오래걸림.. 스택이란 개념을 캐치하고나서 바로풀긴했는데..
    //아래 풀이를 참고해서 스택관련 공부좀 해야될듯..
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


    fun mockTest(answers: IntArray): IntArray {

        val case1 = intArrayOf(1, 2, 3, 4, 5) /// 반복이 5개
        val case2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)  //반복이 8개
        val case3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)   //반복이 10개

        var sameNum1 = 0
        var sameNum2 = 0
        var sameNum3 = 0

        for (i in 0 until answers.size) {
            if (case1[i % case1.size] == answers[i % answers.size]) {
                sameNum1 += 1
            }
        }
        for (i in 0 until answers.size) {
            if (case2[i % case2.size] == answers[i % answers.size]) {
                sameNum2 += 1
            }
        }
        for (i in 0 until answers.size) {
            if (case3[i % case3.size] == answers[i % answers.size]) {
                sameNum3 += 1
            }
        }

        val array = intArrayOf(sameNum1, sameNum2, sameNum3)

        return when {
            array.distinct().size == 1 -> intArrayOf(1, 2, 3)
            else -> when {
                array.max() == array[0] -> {
                    when {
                        array[1] == array[0] -> {
                            intArrayOf(1, 2)
                        }
                        array[2] == array[0] -> {
                            intArrayOf(1, 3)
                        }
                        else -> intArrayOf(1)
                    }
                }
                array.max() == array[1] -> when {
                    array[1] == array[0] -> {
                        intArrayOf(1, 2)
                    }
                    array[2] == array[1] -> {
                        intArrayOf(2, 3)
                    }
                    else -> intArrayOf(2)
                }
                else -> when {
                    array[2] == array[0] -> {
                        intArrayOf(1, 3)
                    }
                    array[2] == array[1] -> {
                        intArrayOf(2, 3)
                    }
                    else -> intArrayOf(3)
                }
            }
        }
    }
    //개인적으로 이렇게 생각을 했엇어야 됬는데 경우의수가 될 수 있는 2^3만 처리하면 된다 생각해서 조잡하게 한듯..
    //갯수를 반환하는 fun getNum(case : IntArray, answers: IntArray) : Int 로 함수 만들고 했으면 더 깔끔할듯.
    // val array = intArrayOf(sameNum1, sameNum2, sameNum3).max()
    //
    //        val resultArray = mutableListOf<Int>()
    //
    //        if (sameNum1 == array) resultArray.add(1)
    //        if (sameNum2 == array) resultArray.add(2)
    //        if (sameNum3 == array) resultArray.add(3)
    //
    //        return resultArray.toIntArray()


    //문제보면 내림차순 이런게 없었는데 계속 제일 작은수 제거하라해서 내림차순한뒤 제거해서 계속 답이 아니었군..
    fun getMinimumNum(arr: IntArray): IntArray =
        if (arr.isEmpty() || arr[0] == 10) {
            intArrayOf(-1)
        } else {
            arr.filter { it != arr.min() }.map { it }.toIntArray()
        }


    //Math 함수 써도 상관없었는데 바로 생각이 나지 않아서 이렇게 했는데 확실히 for문에 범위가 넓으니
    //불필요하게 돌릴필요없는 제한적인 구문을 넣어줘서 시간을 단축시키는게 필요하네..
    fun squareRoot(n: Long): Long {
        var result = 0L
        for (i in 1..50000000000000) {
            if (i * i == n) {
                result = ((i + 1) * (i + 1))
                break
            } else if (i * i > n) {
                break
            }
        }
        return if (result == 0L) {
            -1
        } else {
            result
        }
    }


    //사실 num == 0 도 제거해도 상관없지만 먼가 조건을 명시해주고 싶어서..
    fun evenAndOdd(num: Int): String {
        return when {
            num == 0 -> "Even"
            num % 2 == 0 -> "Even"
            else -> "Odd"
        }
    }

    //좀 독특하게 풀긴 했는데 결국 이문제는 최대공약수 구하는게 관건이다.
    fun maximumCommonFactorMinimumCmmonMultiple(n: Int, m: Int): IntArray {
        val array = mutableListOf<Int>()
        for (i in 1..max(n, m)) {
            if (n % i == 0 && m % i == 0)
                array.add(i)
        }
        return intArrayOf(array[array.lastIndex], (n * m) / array[array.lastIndex])
    }
    //이런 스타일이 괜찮은듯. (최대공약수 구하는 함수.)
    //fun gcm(a: Int, b: Int): Int {
    //        if (b == 0) {
    //            return a
    //        } else {
    //            return gcm(b, a%b)
    //        }
    //    }


    //나도 간단하게 풀었다 생각했지만
    // arr.average() 대박인듯..
    fun average(arr: IntArray): Double =
        arr.sumByDouble { it.toDouble() } / arr.size


    //tailrec  이걸 많이 사용하는 이유가 모지...
    //거의다 나랑 같은 방식이네..
    fun collatz(num: Int): Int {
        var count = num
        var result = 0

        for (i in 0..501) {
            if (i == 501 && count != 1) {
                result = -1
            } else if (count == 1) {
                result = i
                break
            } else {
                when {
                    count % 2 == 1 -> {
                        count = (count * 3) + 1
                    }
                    num % 2 == 0 -> {
                        count /= 2
                    }
                }
            }
        }
        return result
    }

    //오래걸릴게 아닌데..ㅜ
    fun coverPhoneNumber(s: String): String {
        var result = ""
        s.forEachIndexed { index, c ->
            result += if (index < s.lastIndex - 3) {
                "*"
            } else {
                "$c"
            }
        }
        return result
    }
    //아래같이가 괜찮을듯 위에서 한데로 응용.
    //return phone_number.mapIndexed { index, c ->
    //            if (phone_number.length - 5 < index) c else '*'
    //        }.joinToString(separator = "")


    //짧게 한사람들중 중 좀 다른게 it으로 받는게 char 형이다보니 stirng으로 바꾸고 int형으로 바꾸지 않으면
    //-48 해줘야 되는데 그 차이인듯 싶다.. 한 2개정도는 fold란걸 썻는데.. 사실 떠오르지 않을것 같다..
    fun hazard(x: Int): Boolean {
        return x % x.toString().sumBy { it.toString().toInt() } == 0
    }

    //음.. add 할때  (x*i).toLong(), x.toLong() * i  랑의 차이를 알아야 할듯..
    fun spacingAsManyAsX(x: Int, n: Int): LongArray {
        val array = mutableListOf<Long>()
        for (i in 1..n) {
            array.add((x.toLong() * i))
        }
        return array.toLongArray()
    }
    //LongArray(n) { x.toLong() * (it + 1) } 예술임..ㅜ


    //왜이리 어렵게 생각했는지 모르겟네..ㅜ
    fun additionOfMatrix(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        for (i in 0 until arr1.size) {
            val t = mutableListOf<Int>()
            for (j in 0 until arr1[0].size) {
                t.add(arr1[i][j] + arr2[i][j])
            }
            result.add(t.toIntArray())
        }
        return result.toTypedArray()
    }
    //간단하네..
//    return Array(arr1.size) {
//            row ->
//            IntArray(arr1[0].size) {
//                col ->
//                arr1[row][col] + arr2[row][col]
//            }
//        }

    //mapIndexed로 구현한건데 알아두면 편할듯..
    //var answer = arrayOf<IntArray>()
    //
    //       answer = arr1.mapIndexed { indexArr, ints ->
    //          ints.mapIndexed { indexInts, i ->
    //             i + arr2[indexArr][indexInts]
    //          }.toIntArray()
    //       }.toTypedArray()


    // 0/0을 대응해줬어야 했구만.. 사실 0/0은 0이니 상관없다 생각했엇는데.. ㅜ
    // 어찌됬건 map, hashMap 에 대해서 공부좀 더 해야될듯..
    fun rateFail(N: Int, stages: IntArray): IntArray {
        val array = mutableListOf<Float>()
        var size = stages.size

        for (i in 1..N) {
            var count = 0

            stages.forEach {
                if (it == i)
                    count += 1
            }

            if (size == 0) {
                array.add((0).toFloat())
            } else {
                array.add((count.toFloat()) / size)
                size -= count
            }
        }

        val map = mutableMapOf<Int, Float>()
        array.forEachIndexed { index, fl ->
            map[index + 1] = fl
        }

        val descendArray = map.toList().sortedByDescending { (_, value) -> value }.toMap()

        return descendArray.map { it.key }.toIntArray()
    }

}
