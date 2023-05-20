package data.repository

import data.source.OrdersDataSource
import domain.OrdersRepository
import domain.model.Order
import map

class OrdersRepositoryImpl(private val dataSource: OrdersDataSource) : OrdersRepository {
    override fun getOrders(): List<Order> = dataSource.getOrdersList().map { it.map() }

    override fun getOrderId(id: Int): Order? = getOrders().find { it.id == id }

    override fun saveGuests(orders: List<Order>) {
        dataSource.saveOrdersList(orders.map { it.map() })
    }
}
