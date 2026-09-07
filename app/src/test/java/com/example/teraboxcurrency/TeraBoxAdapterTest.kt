package com.example.teraboxcurrency

import com.example.teraboxcurrency.data.cloud.TeraBoxAdapter
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class TeraBoxAdapterTest {
    @Test
    fun uploadFailsSafelyWhenNotConfigured() = runTest {
        val result = TeraBoxAdapter().upload("test.txt", byteArrayOf(1, 2, 3))
        assertTrue(result.isFailure)
    }

    @Test
    fun downloadFailsSafelyWhenNotConfigured() = runTest {
        val result = TeraBoxAdapter().download("test.txt")
        assertTrue(result.isFailure)
    }
}
