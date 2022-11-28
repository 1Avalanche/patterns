interface Deliveryable {
    val deliveryZone: DeliveryZone
    fun getDeliveryInfo()
}

interface DeliveryZone {
    fun getDeliveryDuration() : Int
    fun getDeliveryCost() : Int
}

class FirstDeliveryZone() : DeliveryZone {
    private val deliveryDurationDays = 1
    private val deliveryCost = 0
    override fun getDeliveryDuration(): Int {
        return deliveryDurationDays
    }

    override fun getDeliveryCost(): Int {
        return deliveryCost
    }

}

class SecondDeliveryZone() : DeliveryZone {
    private val deliveryDurationDays = 2
    private val deliveryCost = 500
    override fun getDeliveryDuration(): Int {
        return deliveryDurationDays
    }

    override fun getDeliveryCost(): Int {
        return deliveryCost
    }

}

class DeliveryableOrder(val id: Int, override val deliveryZone: DeliveryZone): Deliveryable {
    override fun getDeliveryInfo() {
        println("You order with id $id will be delivered in ${deliveryZone.getDeliveryDuration()} days, " +
                "and delivery cost is ${deliveryZone.getDeliveryCost()}")
    }
}

fun main() {
    val order1 = DeliveryableOrder(
        id = 123456,
        deliveryZone = FirstDeliveryZone()
    )
    val order2 = DeliveryableOrder(
        id = 78901,
        deliveryZone = SecondDeliveryZone()
    )
    order1.getDeliveryInfo()
    order2.getDeliveryInfo()
}

