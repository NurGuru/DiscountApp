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
    var status: Status = Status.NEW,
    var discount: Discount = Discount.NONE,

)