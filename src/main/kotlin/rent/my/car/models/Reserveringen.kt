package rent.my.car.models


import kotlinx.serialization.Serializable


//
@Serializable
data class Reserveringen(
    val userid: Int,
    val car: String,
    val timeBlock: ReserveringenCategory,
    val price: Int,
)
enum class ReserveringenCategory {
    MONDAY,
    WEDNESDAY,
    FRIDAY
}



