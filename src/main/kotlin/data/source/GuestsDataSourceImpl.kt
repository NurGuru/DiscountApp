package data.source

import data.model.Discount
import data.model.Guest
import data.model.Status

class GuestsDataSourceImpl(private val parser: CsvParser, private val loader: FileLoader) : GuestsDataSource {
    override fun getGuestsList(): List<Guest> {

        val guestsLines = loader.readFromTextFile(Constants.GUESTS_FILE_PATH)
        val parsedGuests = parser.parse(guestsLines, Constants.DELIMITER_SLASH)
        return parsedGuests
            .map {
                Guest(
                    id = it[0].trim().toInt(),
                    name = it[1].trim(),
                    number = it[2].trim().toLong(),
                    visits = it[3].trim().toInt(),
                    moneySpent = it[4].trim().toInt(),
                    status = Status.fromString(it[5]),
                    discount = Discount.fromString(it[6])
                )
            }.toList()
    }
}

