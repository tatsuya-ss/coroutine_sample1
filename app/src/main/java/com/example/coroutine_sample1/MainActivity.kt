package com.example.coroutine_sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val scope = CoroutineScope(Job() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scope.launch {
            val customName1 = async { customName("たつや") }
            val customName2 = async { customName("坂本") }

            val result1 = customName1.await()
            val result2 = customName2.await()
            Log.d("Tatsuyað", "result1: ${result1}")
            Log.d("Tatsuyað", "result2: ${result2}")
        }

    }

    private suspend fun customName(name: String): String {
        delay(1000)
        return name + "さん"
    }
}