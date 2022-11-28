

    interface Modulable {
        val modulesCount: Int
        val costByModule: Int
        fun getCost(): Int
    }

    class Kitchen(override val modulesCount: Int, override val costByModule: Int) : Modulable {
        override fun getCost(): Int {
            return modulesCount * costByModule
        }
    }

    class Wardrobe(override val modulesCount: Int, override val costByModule: Int) : Modulable {
        override fun getCost(): Int {
            return modulesCount * costByModule
        }
    }

    class DeliveryModulable(
        private val modulable: Modulable,
        private val deliveryByModule: Int
    ) : Modulable by modulable {
        override fun getCost(): Int {
            return modulable.getCost() + getCostForAssembly()
        }

        private fun getCostForAssembly() : Int {
            return deliveryByModule * modulable.modulesCount
        }
    }

    class RiceModulable(
        private val modulable: Modulable,
        private val riceOneFloorByModule: Int,
        private val clientFloor: Int,
        private val hasElevator: Boolean
    ) : Modulable by modulable {

        override fun getCost(): Int {
            return modulable.getCost() + getCostForRice()
        }

        private fun getCostForRice() : Int {
           return if (hasElevator) {
               modulable.modulesCount * riceOneFloorByModule
            } else {
                modulable.modulesCount * clientFloor * riceOneFloorByModule
           }
        }
    }


    class AssemblyModulable(
        private val modulable: Modulable,
        private val assemblyCostByModule: Int,
        private val discount: Int
    ) : Modulable by modulable {
        override fun getCost(): Int {
            return getFinishCost()
        }

        private fun getCostForAssembly() : Int {
            return modulable.modulesCount * assemblyCostByModule
        }

        private fun getFinishCost(): Int {
            val finishCost = getCostForAssembly() + modulable.getCost()
            return if (finishCost > 300000) {
                finishCost - discount
            } else {
                finishCost
            }
        }
    }

    data class Typeio(
        private val first: Int,
        private val second: String
    )

    fun main() {
        val baseModulable1 = Kitchen(modulesCount = 10, costByModule = 12000)
        val baseModulable2 = Wardrobe(modulesCount = 8, costByModule = 8500)
        val kitchenCostInStore = baseModulable1.getCost()
        println("base modulable cost in store: $kitchenCostInStore")

        val kitchenCostWithDeliveryAndPick = RiceModulable(
            modulable = DeliveryModulable(
                modulable = baseModulable1,
                deliveryByModule = 200
            ),
            riceOneFloorByModule = 70,
            clientFloor = 5,
            hasElevator = false
        ).getCost()
        println("base modulable cost with delivery and pick cost: $kitchenCostWithDeliveryAndPick")

        val kitchenFullConstruction = AssemblyModulable(
            modulable = RiceModulable(
                modulable = DeliveryModulable(
                    modulable = baseModulable1,
                    deliveryByModule = 200,
                ),
                riceOneFloorByModule = 70,
                clientFloor = 16,
                hasElevator = true
            ),
            assemblyCostByModule = 1000,
            discount = 5000
        ).getCost()
        println("base modulable in full construction cost: $kitchenFullConstruction")

    }



