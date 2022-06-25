package com.example.coroutine_sample1

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Test

class MovieTest {

    @Test
    fun 映画のタイトルが取得できていること() = runBlocking {
        val movie = Movie()
        val expectation = listOf("君の名は", "コンフィデンスマンJP", "ハリーポッター")
        assertEquals(expectation, movie.fetchTitles())
    }

//    @Test
//    fun 映画のタイトルが取得できていることrunBlocking使わない() {
//        val movie = Movie()
//        val expectation = listOf("君の名は", "コンフィデンスマンJP", "ハリーポッター")
//        assertEquals(expectation, movie.fetchTitles())
//    }

}