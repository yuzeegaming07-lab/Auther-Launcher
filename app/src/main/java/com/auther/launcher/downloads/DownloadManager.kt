package com.auther.launcher.downloads

import java.io.File
import java.net.HttpURLConnection
import java.net.URL

class DownloadManager(
    private val downloadDirectory: File
) {

    fun download(
        url: String,
        fileName: String,
        onProgress: (Long, Long) -> Unit = { _, _ -> }
    ): Result<File> {

        if (!fileName.matches(Regex("[a-zA-Z0-9._-]+"))) {
            return Result.failure(
                IllegalArgumentException("Nama file tidak valid")
            )
        }

        return try {
            if (!downloadDirectory.exists()) {
                downloadDirectory.mkdirs()
            }

            val destination = File(downloadDirectory, fileName)
            val connection =
                URL(url).openConnection() as HttpURLConnection

            try {
                connection.connectTimeout = 15000
                connection.readTimeout = 30000
                connection.requestMethod = "GET"
                connection.connect()

                if (connection.responseCode !in 200..299) {
                    error("HTTP ${connection.responseCode}")
                }

                val total = connection.contentLengthLong

                connection.inputStream.use { input ->
                    destination.outputStream().use { output ->

                        val buffer = ByteArray(8192)
                        var downloaded = 0L

                        while (true) {
                            val count = input.read(buffer)

                            if (count == -1) break

                            output.write(buffer, 0, count)
                            downloaded += count

                            onProgress(downloaded, total)
                        }
                    }
                }

                Result.success(destination)

            } finally {
                connection.disconnect()
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
