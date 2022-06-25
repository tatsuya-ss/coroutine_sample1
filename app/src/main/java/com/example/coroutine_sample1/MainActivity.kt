package com.example.coroutine_sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    private val scope = CoroutineScope(Job() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scope.launch {
            val time = measureTimeMillis {
                val result1 = async { getCountInOneSecond() }
                val result2 = async { getCountInTwoSecond() }
                Log.d("Tatsuya", "合計は: ${result1.await() + result2.await()}")
            }
            Log.d("Tatsuya", "かかった時間: ${time}")
        }

    }

    private suspend fun getCountInOneSecond(): Int {
        delay(1000)
        return 10
    }

    private suspend fun getCountInTwoSecond(): Int {
        delay(2000)
        return 20
    }
}