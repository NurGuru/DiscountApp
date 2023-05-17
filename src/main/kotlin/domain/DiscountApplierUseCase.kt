package domain

import domain.model.Discount
import domain.model.Guest
import domain.model.Status
import data.source.Constants

class DiscountApplierUseCase(

) {
    /**
     *[applyDiscountAndChangeStatus] - меняет статус и скидку гостю в зависимости от потраченных денег и визитов.
     1.Если набрал 10 или более посещений, то меняется статус на [Status.GOOD] и скидка [Discount.FIRST_DISCOUNT]
     2.Если потратил 50 тыс и более, то меняется статус на [Status.VIP] и скидка [Discount.SECOND_DISCOUNT]
     * @param guest гость к которму применится функция
     * @return возвращает "обновленного" гостя
     */
    fun applyDiscountAndChangeStatus(guest: Guest): Guest {
        var guestForApply = guest

        if (guestForApply.visits >= Constants.COUNT_TO_GET_STATUS_GOOD) {
            guestForApply = guestForApply.copy(status = Status.GOOD, discount = Discount.FIRST_DISCOUNT)
        }

        if (guestForApply.visits >= Constants.COUNT_TO_GET_STATUS_GOOD
            && guestForApply.moneySpent >= Constants.COUNT_TO_GET_STATUS_VIP
        ) {
            guestForApply = guestForApply.copy(status = Status.VIP, discount = Discount.SECOND_DISCOUNT)
        }

        return guestForApply
    }
}

