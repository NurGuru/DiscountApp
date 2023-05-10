import data.model.Status

fun main() {
    val adapter = Di.createGuestAdapter()

    /**
    первая фича - отображать информацию о госте по айдишнику
     */
    adapter.getGuestByIdAndPrintInfo(1)

    /**
    вотрая фича - отображать список гостей с определенным статусом лоялности
     */
    adapter.getGuestsWithStatus(Status.VIP)

    /**
    третья фича - добавлять посещения гостю по айди
     */
    adapter.addVisitsToGuest(3)
}