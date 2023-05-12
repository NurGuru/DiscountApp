package domain

class AddMoneySpentUseCase(
    private val repository: GuestsRepository,
    private val applier:ApplyDiscountUseCase
) {
    /**
     *addMoneySpent - функция по добавлению потраченных денег гостю.
     * @param id айди гостя.
     * @param addingMoneySpentCount сумма добовляемая к потрченным гостем деньгам.
     */
    fun addMoneySpent(id: Int, addingMoneySpentCount: Int) {
        var guest = repository.getGuestById(id)
        if (guest != null) {
            guest = guest.copy(moneySpent = guest.moneySpent + addingMoneySpentCount)

           applier.apply(guest)
        }
    }
}
