package com.work.codingtest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val c = intArrayOf(1, 3, 2, 4)

        c.filter { it != c.min() }.map { it }.sortedDescending().toIntArray().forEach {
            Log.d("결과1", "$it")
        }
    }
}


