package domain

import domain.model.Guest

/**
 * [apply] - функция применяющая скидку
 */
class ApplyDiscountUseCase(
    private val discountApplier: DiscountApplierUseCase,
    private val repository: GuestsRepository,
    private val save: SaveGuestsListUseCase
) {
    fun apply(guest: Guest): List<Guest> {
        var newGuest = guest
        newGuest = discountApplier.applyDiscountAndChangeStatus(newGuest)

        val newGuestsList = repository.getGuests().map {
            if (it.id == newGuest.id) newGuest else it
        }

        save.saveNewGuestsList(newGuestsList)
        return newGuestsList
    }
}
