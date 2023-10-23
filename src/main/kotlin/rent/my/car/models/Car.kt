package rent.my.car.models

import kotlinx.serialization.Serializable

@Serializable
data class Car(
    val brand: String,
    val type: String,
    val category: CarCategory,
//    val rentalConditions: RentalConditions,
    val owner: User,
//    val photos: List<String>
)

enum class CarCategory {
    ICE,
    BEV,
    FCEV
}

data class RentalConditions(
    val price: Double,
    val pickupDropOff: String
)

data class RentalCar(
    val car: Car,
    val availability: List<TimeBlock>
)

data class TimeBlock(
    val startTime: Long,
    val endTime: Long
)

class CarRentalApplication {
    // fun showCarList(criteria: FilterCriteria): List<Car> {
    //     // Implement logic to display cars based on criteria
    //     return emptyList()
    // }

    // fun showCarsOnMap(criteria: FilterCriteria): List<Car> {
    //     // Implement logic to display cars on the map based on criteria
    //     return emptyList()
    // }
}
