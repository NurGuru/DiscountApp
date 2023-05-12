package data.repository

import domain.model.Guest
import domain.model.Status
import data.source.GuestsDataSource
import domain.GuestsRepository
import map

class GuestsRepositoryImpl(private val dataSource: GuestsDataSource) : GuestsRepository {

    override fun getGuests(): List<Guest> = dataSource.getGuestsList().map { it.map() }

    override fun getGuestById(id: Int): Guest? = getGuests().find { it.id == id }

    override fun getGuestListByStatus(status: Status): List<Guest> = getGuests().filter { it.status == status }

    override fun saveGuests(guests: List<Guest>) {
        dataSource.saveGuestsList(guests.map { it.map() })
    }

}