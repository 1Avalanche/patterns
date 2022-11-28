
        interface Order {
           fun getOrderId() : String
           fun getOrderStatus() : String
        }

        class CustomerOrder(
            private val id: String,
            private val status: String,
            val products: List<Int>,
        ) : Order {
            override fun getOrderId(): String = id
            override fun getOrderStatus(): String = status
        }


        abstract class OrderDecorator(
            private val concreteOrder: Order
        ) : Order

        class OrderUiDecorator(
            order: Order
        ) : OrderDecorator(order) {
            override fun getOrderId(): String {
                return "Заказ № - ${getOrderId()}"
            }

            override fun getOrderStatus(): String {
                return "Статус заказа ${getOrderStatus()}"
            }
        }