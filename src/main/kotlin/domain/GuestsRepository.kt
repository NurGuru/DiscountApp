package domain

import domain.model.Guest
import domain.model.Status

interface GuestsRepository {

    fun getGuests(): List<Guest>

    fun getGuestById(id: Int): Guest?

    fun getGuestListByStatus(status: Status): List<Guest>

    fun saveGuests(guests: List<Guest>)
}