package com.example.teraboxcurrency.data.cloud

/**
 * TeraBox integration boundary.
 *
 * The official TeraBox Open Platform/API credentials and endpoint contract
 * must be supplied before network operations are enabled. No credentials are
 * embedded in the app.
 */
class TeraBoxAdapter : CloudStorageAdapter {
    override val providerName: String = "TeraBox"

    override suspend fun upload(path: String, bytes: ByteArray): Result<String> =
        Result.failure(UnsupportedOperationException("TeraBox API/OAuth configuration is required"))

    override suspend fun download(path: String): Result<ByteArray> =
        Result.failure(UnsupportedOperationException("TeraBox API/OAuth configuration is required"))
}
