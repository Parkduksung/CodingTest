package com.work.codingtest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val c1 = mutableListOf<IntArray>()
        c1.add(intArrayOf(1))
        c1.add(intArrayOf(2))

        val c2 = mutableListOf<IntArray>()
        c2.add(intArrayOf(1))
        c2.add(intArrayOf(2))

        Log.d("결과는", c1.size.toString())
        Log.d("결과는", c1[0].size.toString())

        val result = mutableListOf<IntArray>()


        for (i in 0 until c1.size) {
            val t = mutableListOf<Int>()
            for (j in 0 until c1[0].size) {
                t.add(c1[i][j] + c2[i][j])
            }
            result.add(t.toIntArray())
        }

        Log.d("결과는", result.size.toString())
        Log.d("결과는", result[0].size.toString())

    }
}


