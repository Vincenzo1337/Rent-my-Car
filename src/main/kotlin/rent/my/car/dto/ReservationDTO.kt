package rent.my.car.dto

import ReservationsCategory
import kotlinx.serialization.Serializable
import rent.my.car.models.Car
import rent.my.car.models.TimeBlock
import rent.my.car.models.User

@Serializable
data class ReservationDTO(
    val userid: Int,
    val car: String,
    val timeBlock: ReservationsCategory,
    val price: Int,
)