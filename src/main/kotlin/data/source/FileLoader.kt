package data.source

import java.io.File

class FileLoader {

    fun readFromTextFile(path: String): List<String> = File(path)
        .bufferedReader()
        .lineSequence()
        .filter { it.isNotBlank() }
        .toList()
}