package data.model

/**
 * Guest
 *
 * @param id- айдишник гостя
 * @param name-  имя гостя
 * @param number- номер телефона
 * @param visits- оличество посещений
 * @param moneySpent- потрачено денег в завдении
 * @param status- статус лоялности гостя
 * @param discount- скидка гостя
 *
 * @constructor Create empty Guest
 */
data class Guest(
    val id: Int,
    val name: String,
    val number: Long,
    val visits: Int,
    val moneySpent: Int,
    val status: Status = Status.NEW,
    val discount: Discount = Discount.NONE,
) {
    override fun toString(): String {
        return "$id|$name|$number|$visits|$moneySpent|$status|$discount"
    }
}