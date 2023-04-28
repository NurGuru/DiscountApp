package data.source

import java.io.File


class FileLoader {

    fun readFromTextFile(path: String): List<String> =
        if (File(path).exists()) {

            File(path)
                .bufferedReader()
                .lineSequence()
                .filter { it.isNotBlank() }
                .toList()
        } else {
            emptyList()
        }
}