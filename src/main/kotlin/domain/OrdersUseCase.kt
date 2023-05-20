package domain

class OrdersUseCase(private val repository: OrdersRepository) {

    fun getSumOfAllOrders(): Int = repository.getOrders().sumOf { it.sum }

    fun getAverageOrderSum():Int =getSumOfAllOrders()/ getOrdersCount()

    private fun getOrdersCount():Int=repository.getOrders().size
}