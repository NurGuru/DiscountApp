package data.repository

import data.model.Guest
import data.source.GuestsDataSource
import domain.GuestsRepository

class GuestsRepositoryImpl(private val dataSource: GuestsDataSource) : GuestsRepository {
    override fun getGuests(): List<Guest> = dataSource.getGuestsList()
}