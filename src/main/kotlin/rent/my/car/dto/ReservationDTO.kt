package rent.my.car.dto

import kotlinx.serialization.Serializable
import rent.my.car.models.Car
import rent.my.car.models.TimeBlock
import rent.my.car.models.User

@Serializable
data class ReservationDTO(
    val reservationId: Int,
    val userId: User,
    val carId: Car,
    val timeBlockId: TimeBlock
)