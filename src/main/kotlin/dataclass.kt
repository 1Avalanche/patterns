
        interface StoreOrder {
            fun getClientData(): String
        }

        data class ClientOrder(
            val id: String,
            private  val clientId: Int,
            val dateCreate: String,
            val status: String,
            val products: List<Int>,
            //and more values
        ) : StoreOrder {
            override fun getClientData(): String {
                return clientId.toString()
            }
        }

        val order = ClientOrder(
            id = "c012345",
            clientId = 6789,
            dateCreate = "2022-11-01",
            status = "NEW",
            products = listOf(14834516, 18373737)
        )

        val updatedStatusOrder = order.copy(
            status = "COMPLETED"
        )

        fun main() {
            val id = updatedStatusOrder.id
            //val clientId = updatedStatusOrder.clientId
            val clientData = updatedStatusOrder.getClientData()
        }
