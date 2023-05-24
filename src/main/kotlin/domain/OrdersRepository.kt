package domain

import domain.model.Order

interface OrdersRepository {
    fun getOrders(): List<Order>

    fun getOrderId(id: Int): Order?

    fun saveGuests(orders: List<Order>)
}