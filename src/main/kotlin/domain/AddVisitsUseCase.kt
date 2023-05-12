package domain

class AddVisitsUseCase(
    private val repository: GuestsRepository,
    private val applier:ApplyDiscountUseCase
) {
    /**
     *[addVisits] - функция по добавлению визитов гостю.
     * @param id - айди гостя.
     * @param addingVisitsCount - число визитов добовляемое к уже имеющимся визитам гостя.
     */
    fun addVisits(id: Int, addingVisitsCount: Int) {
        var guest = repository.getGuestById(id)
        if (guest != null) {
            guest = guest.copy(visits = guest.visits + addingVisitsCount)
            applier.apply(guest)
        }
    }
}