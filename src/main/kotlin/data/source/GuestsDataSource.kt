package data.source

import data.model.Guest

interface GuestsDataSource {
    fun getGuestsList(): List<Guest>
}