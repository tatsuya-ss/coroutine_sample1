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

        scope.launch {  }

        runBlocking {
            Thread.sleep(5000)
        }

    }
}

class Movie {
    suspend fun fetchTitles(): List<String> {
        delay(1000)
        return listOf("君の名は", "コンフィデンスマンJP", "ハリーポッター")
    }
}