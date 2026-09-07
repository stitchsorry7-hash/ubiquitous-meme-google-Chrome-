package com.example.teraboxcurrency.data.cloud

interface CloudStorageAdapter {
    val providerName: String
    suspend fun upload(path: String, bytes: ByteArray): Result<String>
    suspend fun download(path: String): Result<ByteArray>
}
