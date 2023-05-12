package domain

import data.source.Saver

class AddVisitsUseCaseImpl(
    private val guestGetter: GuestsUseCase,
    private val repository: GuestsRepository,
    private val saver: Saver,
) : AddVisitsUseCase {
    override fun addVisits(id: Int, addingVisitsCount: Int) {

        var listOfGuests = repository.getGuests()

        listOfGuests = listOfGuests.map {
            if (it.id == guestGetter.getGuestById(id)?.id) {
                it.copy(visits = it.visits + addingVisitsCount)
            } else it
        }
        saver.saveChangesInText(listOfGuests)
    }
}