package data.source

import data.model.GuestEntity

interface GuestsDataSource {

    fun getGuestsList(): List<GuestEntity>

    fun saveGuestsList(newGuestsList: List<GuestEntity>)
}