
import kotlinx.serialization.Serializable
import rent.my.car.models.TimeBlock

@Serializable
data class Reservation(
    val userid: Int,
    val carId: Int,
    val timeBlock: TimeBlock,
    val price: Int,
)
enum class ReservationsCategory {
    MONDAY,
    WEDNESDAY,
    FRIDAY
}