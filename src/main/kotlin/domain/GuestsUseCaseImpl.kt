package domain

import data.model.Guest
import data.model.Status

class GuestsUseCaseImpl(
    private val repository: GuestsRepository,) : GuestsUseCase {
    override fun getGuestById(id: Int): Guest? = repository.getGuests().find { it.id == id }

    override fun getGuestListByStatus(status: Status): List<Guest> =
        repository.getGuests().filter { it.status == status }
}
