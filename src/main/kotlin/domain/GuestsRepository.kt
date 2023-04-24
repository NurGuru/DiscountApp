package domain

import data.model.Guest

interface GuestsRepository {
    fun getGuests(): List<Guest>
}