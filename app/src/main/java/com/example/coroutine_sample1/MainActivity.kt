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

        runBlocking {
            Log.d("Tatsuya", "runBlocking: ${Thread.currentThread()}")

            scope.launch {
                runBlocking {
                    Log.d("Tatsuya", "Dispatchers.MainのrunBlocking: ${Thread.currentThread()}")
                }
            }

            scope.launch(Dispatchers.Default) {
                runBlocking {
                    Log.d("Tatsuya", "Dispatchers.DefaultのrunBlocking: ${Thread.currentThread()}")
                }
            }

            scope.launch(Dispatchers.IO) {
                withContext(Dispatchers.Main) {
                    runBlocking {
                        Log.d("Tatsuya", "Dispatchers.IO.DefaultでwithContextでMainに切り替えたrunBlocking: ${Thread.currentThread()}")
                    }
                }
                runBlocking {
                    Log.d("Tatsuya", "Dispatchers.IO.DefaultのrunBlocking: ${Thread.currentThread()}")
                }
            }

        }
    }
}