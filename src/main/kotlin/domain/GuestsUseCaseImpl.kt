package domain

import data.model.Guest

class GuestsUseCaseImpl(private val repository: GuestsRepository) : GuestsUseCase {
    override fun getGuestById(id: Int): Guest? = repository.getGuests().find { it.id == id }
}