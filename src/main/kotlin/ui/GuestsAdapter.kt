package ui

import data.model.Status
import domain.GuestsUseCase

class GuestsAdapter(
    private val guestsUseCase: GuestsUseCase,
) {
    fun getGuestByIdAndPrintInfo(id: Int) {
        val guest = guestsUseCase.getGuestById(id)
        if (guest != null) {
            println(
                """
               Имя гостя с id ${guest.id} - ${guest.name}
               Телефон гостя ${guest.name} - ${guest.number}
               Гость ${guest.name} постетил заведение ${guest.visits} раз
               Гость ${guest.name} потратил ${guest.moneySpent}руб.
               Статус гостя ${guest.name} - ${guest.status}
               У гостя ${guest.name} скидка ${guest.discount}
               
            """.trimIndent()
            )
        }
    }

    fun getGuestsWithStatus(status: Status)  {
         val guestWithStatus = guestsUseCase.getGuestListByStatus(status)
        for (guest in guestWithStatus){
            println("У гостя ${guest.name} статус ${guest.status}")
        }
    }
}