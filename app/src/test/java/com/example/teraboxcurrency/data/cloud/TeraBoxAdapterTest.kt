package com.example.teraboxcurrency.data.cloud

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class TeraBoxAdapterTest {
    @Test
    fun uploadRequiresOfficialConfiguration() = runBlocking {
        val result = TeraBoxAdapter().upload("test.txt", "test".toByteArray())
        assertTrue(result.isFailure)
    }

    @Test
    fun downloadRequiresOfficialConfiguration() = runBlocking {
        val result = TeraBoxAdapter().download("test.txt")
        assertTrue(result.isFailure)
    }
}
