package rent.my.car.dto

import kotlinx.serialization.Serializable
import rent.my.car.models.ReserveringenCategory
import rent.my.car.models.TimeBlock

@Serializable
data class ReserveringenDTO(
    val userid: Int,
    val car: String,
    val timeBlock: ReserveringenCategory,
    val price: Int,
)
