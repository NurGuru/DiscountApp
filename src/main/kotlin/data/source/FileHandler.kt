package data.source

import java.io.File

class FileHandler {

    fun readFromTextFile(path: String): List<String> {

        println("При загрузке текста из файла работатет поток: ${Thread.currentThread().name}\n")

        return if (File(path).exists()) {
            File(path)
                .bufferedReader()
                .lineSequence()
                .filter { it.isNotBlank() }
                .toList()
        } else {
            emptyList()
        }

    }

    fun saveText(path: String, text: String) =
        try {
            File(path).writeText(text)
        } catch (e: Exception) {
            e.fillInStackTrace()
        }
}


