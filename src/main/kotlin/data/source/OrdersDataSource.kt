package data.source

import data.model.OrderEntity

interface OrdersDataSource {
    fun getOrdersList(): List<OrderEntity>

    fun saveOrdersList(newOrdersList: List<OrderEntity>)
}