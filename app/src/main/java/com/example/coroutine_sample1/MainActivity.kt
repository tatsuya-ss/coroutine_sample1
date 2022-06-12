package com.example.coroutine_sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity(
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.Main
) : AppCompatActivity(), CoroutineScope {

    // private val scope = CoroutineScope(Job() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        scope.launch {
        launch {
            fetch()
        }


    }

    private suspend fun fetch() {
        delay(1000L)
        Log.d("Tatsuyað", "fetch: 1秒経過")
//        scope.cancel()
        cancel()
        delay(1000L)
        Log.d("Tatsuyað", "fetch: 2秒経過")
    }
}