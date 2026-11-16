package com.auther.launcher.downloads

import java.io.File

class DownloadRepository(directory: File) {

    private val manager = DownloadManager(directory)

    fun downloadFile(
        url: String,
        name: String,
        progress: (Long, Long) -> Unit = { _, _ -> }
    ): Result<File> {
        return manager.download(url, name, progress)
    }
}
