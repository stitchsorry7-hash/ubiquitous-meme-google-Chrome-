package com.example.teraboxcurrency

import com.example.teraboxcurrency.data.cloud.CloudStorageAdapter
import com.example.teraboxcurrency.data.cloud.CloudSyncService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CloudSyncServiceTest {
    private class FakeStorage : CloudStorageAdapter {
        override val providerName = "Fake"
        private var stored = ByteArray(0)
        override suspend fun upload(path: String, bytes: ByteArray): Result<String> {
            stored = bytes.copyOf()
            return Result.success(path)
        }
        override suspend fun download(path: String): Result<ByteArray> = Result.success(stored.copyOf())
    }

    @Test
    fun backupDelegatesToStorage() = runTest {
        val service = CloudSyncService(FakeStorage())
        val result = service.backup("settings.json", byteArrayOf(1, 2, 3))
        assertTrue(result.isSuccess)
        assertEquals("settings.json", result.getOrNull())
    }

    @Test
    fun restoreReturnsStoredBytes() = runTest {
        val storage = FakeStorage()
        val service = CloudSyncService(storage)
        val input = byteArrayOf(4, 5, 6)
        service.backup("settings.json", input)
        assertArrayEquals(input, service.restore("settings.json").getOrThrow())
    }
}
