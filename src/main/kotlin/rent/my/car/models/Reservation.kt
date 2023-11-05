
import kotlinx.serialization.Serializable
import rent.my.car.models.User
import rent.my.car.models.Car
import rent.my.car.models.TimeBlock

@Serializable
data class Reservations(
    val reservationId: Int,
    val userId: User,
    val carId: Car,
    val timeBlockId: TimeBlock
)