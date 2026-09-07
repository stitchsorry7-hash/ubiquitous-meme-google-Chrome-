package com.example.teraboxcurrency.data.cloud

/**
 * Provider-neutral sync facade. App data is serialized by the caller and
 * delegated to the configured cloud provider without exposing credentials.
 */
class CloudSyncService(private val storage: CloudStorageAdapter) {
    suspend fun backup(path: String, data: ByteArray): Result<String> =
        storage.upload(path, data)

    suspend fun restore(path: String): Result<ByteArray> =
        storage.download(path)
}
