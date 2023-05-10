package data.source

import data.model.Guest
import java.io.File

class Saver {
    /**
     * Перезаписывает файл, добавляя измененные данные
     * @param newGuestsList - измененный список
     */
    fun saveChangesInText(newGuestsList: List<Guest>) {
        val file = File(Constants.GUESTS_FILE_PATH)
        file.writeText(newGuestsList.joinToString("\n", "", "\n"))
    }
}
