import data.model.Status

fun main() {
    val adapter = Di.createGuestAdapter()

    adapter.getGuestByIdAndPrintInfo(1)
    adapter.getGuestByIdAndPrintInfo(2)
    adapter.getGuestByIdAndPrintInfo(3)

    adapter.getGuestsWithStatus(Status.NEW)
    adapter.getGuestsWithStatus(Status.GOOD)
    adapter.getGuestsWithStatus(Status.VIP)
}