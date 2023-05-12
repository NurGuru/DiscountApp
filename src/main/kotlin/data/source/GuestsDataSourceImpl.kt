package data.source

import data.model.GuestEntity

class GuestsDataSourceImpl(
    private val parser: CsvParser,
    private val handler: FileHandler,
    private val threadLoading: MultiThreading
) : GuestsDataSource {
    override fun getGuestsList(): List<GuestEntity> {

        val guestsLines = threadLoading.fileLoading(Constants.GUESTS_FILE_PATH)
        val parsedGuests = parser.parse(guestsLines, Constants.DELIMITER_SLASH)
        return parsedGuests
            .map {
                GuestEntity(
                    id = it[0].trim().toInt(),
                    name = it[1].trim(),
                    number = it[2].trim().toLong(),
                    visits = it[3].trim().toInt(),
                    moneySpent = it[4].trim().toInt(),
                    statusStr = it[5],
                    discountStr = it[6]
                )
            }.toList()
    }

    /**
     * Перезаписывает файл, добавляя измененные данные
     * @param newGuestsList - измененный список
     */
    override fun saveGuestsList(newGuestsList: List<GuestEntity>) {
        val text = newGuestsList.joinToString(Constants.SEPARATOR, "", Constants.POSTFIX)
        handler.saveText(Constants.GUESTS_FILE_PATH, text)
    }
}

