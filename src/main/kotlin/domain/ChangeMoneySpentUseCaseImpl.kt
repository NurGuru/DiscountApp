package domain

import data.source.Saver

class ChangeMoneySpentUseCaseImpl(
    private val guestGetter: GuestsUseCase,
    private val repository: GuestsRepository,
    private val saver: Saver,
) : ChangeMoneySpentUseCase {
    override fun changeMoneySpent(id: Int, addingMoneySpentCount: Int) {
        var listOfGuests = repository.getGuests()

        listOfGuests = listOfGuests.map {
            if (it.id == guestGetter.getGuestById(id)?.id) {
                it.copy(moneySpent = it.moneySpent + addingMoneySpentCount)
            } else it
        }
        saver.saveChangesInText(listOfGuests)
    }
}
