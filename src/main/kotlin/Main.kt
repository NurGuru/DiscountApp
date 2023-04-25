fun main() {
    val adapter = Di.createGuestAdapter()

    adapter.getGuestByIdAndPrintInfo(1)
    adapter.getGuestByIdAndPrintInfo(2)
    adapter.getGuestByIdAndPrintInfo(3)
}