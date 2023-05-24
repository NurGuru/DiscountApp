import data.model.GuestEntity
import data.model.OrderEntity
import domain.model.Discount
import domain.model.Guest
import domain.model.Order
import domain.model.Status

fun Guest.map() = GuestEntity(
    id = id,
    name = name,
    number = number,
    visits = visits,
    moneySpent = moneySpent,
    statusStr = status.name,
    discountStr = discount.name
)

fun GuestEntity.map() = Guest(
    id = id,
    name = name,
    number = number,
    visits = visits,
    moneySpent = moneySpent,
    status = Status.fromString(statusStr),
    discount = Discount.fromString(discountStr)
)

fun OrderEntity.map() = Order(
    id = id,
    guestId = guestId,
    sum = sum,
)

fun Order.map() = OrderEntity(
    id = id,
    guestId = guestId,
    sum = sum,
)


