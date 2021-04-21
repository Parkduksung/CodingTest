package com.work.codingtest

import com.work.codingtest.exercism.Exercism
import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //Exercism_Account

    @Test
    fun zeroBalanceWhenOpened() {
        val account = Exercism.BankAccount()
        assertEquals(0, account.balance)
    }

    @Test
    fun sequentialBalanceAdjustments() {
        val account = Exercism.BankAccount()

        account.adjustBalance(1000)
        assertEquals(1000, account.balance)

        account.adjustBalance(-958)
        assertEquals(42, account.balance)
    }

    @Ignore
    @Test
    fun closedAccountHasNoBalance() {
        val account = Exercism.BankAccount()
        account.close()
//        assertFailsWith(IllegalStateException::class) { account.balance }
    }

    @Ignore
    @Test
    fun closedAccountCannotBeAdjusted() {
        val account = Exercism.BankAccount()
        account.close()
//        assertFailsWith(IllegalStateException::class) { account.adjustBalance(1000) }
    }

    @Test
    fun concurrentBalanceAdjustments() {
        val threads = 100
        val iterations = 500
        val random = Random()

        val account = Exercism.BankAccount()

        val executor = Executors.newFixedThreadPool(8)

        repeat(threads) {
            executor.submit {
                repeat(iterations) {
                    account.adjustBalance(1)
                    Thread.sleep(random.nextInt(10).toLong())
                    account.adjustBalance(-1)
                }
            }
        }

        executor.shutdown()
        executor.awaitTermination(10, TimeUnit.MINUTES)

        assertEquals(0, account.balance)
    }


}
