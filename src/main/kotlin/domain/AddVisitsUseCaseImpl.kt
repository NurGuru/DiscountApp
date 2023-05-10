package domain

import data.source.Saver

class AddVisitsUseCaseImpl(
    private val guestGetter: GuestsUseCase,
    private val repository: GuestsRepository,
    private val saver: Saver,
) : AddVisitsUseCase {
    override fun addVisits(id: Int) {

        val guestForVisitAdding = guestGetter.getGuestById(id)
        val addingVisits = readln().toInt()
        var listOfGuests = repository.getGuests()

        for (guest in listOfGuests) {
            if (guest.id == guestForVisitAdding?.id) {
                listOfGuests = listOfGuests.map {
                    if (it.id == guestForVisitAdding.id) {
                        it.copy(visits = guestForVisitAdding.visits + addingVisits)
                    } else it
                }
            }
        }
        saver.saveChangesInText(listOfGuests)
    }
}