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
            val customName = customName("龍哉")
            Log.d("Tatsuyað", "onCreate: ${customName}")
        }

    }

    private suspend fun customName(name: String): String {
        delay(1000)
        return name + "さん"
    }
}