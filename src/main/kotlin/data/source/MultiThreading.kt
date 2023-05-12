package data.source

import java.util.concurrent.Callable
import java.util.concurrent.Executors

/**
 * [fileLoading] - осущетвляет многопоточную загрузку
 */
class MultiThreading(private val fileHandler: FileHandler) {
    private val executorService = Executors.newSingleThreadExecutor()

    fun fileLoading(path: String): List<String> {
        return executorService.submit(Callable { fileHandler.readFromTextFile(path) }).get()
    }
}