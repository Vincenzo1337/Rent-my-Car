
import kotlinx.serialization.Serializable
import rent.my.car.models.User
import rent.my.car.models.Car
import rent.my.car.models.TimeBlock

@Serializable
data class Reservations(
    val userid: Int,
    val car: String,
    val timeBlock: ReservationsCategory,
    val price: Int,
)
enum class ReservationsCategory {
    MONDAY,
    WEDNESDAY,
    FRIDAY
}