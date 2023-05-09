package domain

import data.model.Guest
import data.model.Status

interface GuestsUseCase {
    fun getGuestById(id: Int): Guest?

    fun getGuestListByStatus(status: Status): List<Guest>

}