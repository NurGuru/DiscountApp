package domain

import data.model.Guest

interface GuestsUseCase {
    fun getGuestById(id: Int): Guest?
}