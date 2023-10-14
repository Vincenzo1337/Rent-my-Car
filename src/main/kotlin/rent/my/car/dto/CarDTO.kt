package rent.my.car.dto

import kotlinx.serialization.Serializable
import rent.my.car.models.CarCategory

@Serializable
data class CarDTO(
    val brand: String,
    val type: String,
    val category: CarCategory,
//    val price: Double,
//    val owner: UserDTO,
//    val rentalConditions: CarRentalConditions,
)

@Serializable
data class CarRentalConditions(
//    val car: CarDTO,
    val availability: List<TimeBlockDTO>
)

@Serializable
data class TimeBlockDTO(
    val startTime: Long,
    val endTime: Long
)
