package rent.my.car.models

import kotlinx.serialization.Serializable

@Serializable
data class Car(
    val brand: String,
    val type: String,
    val category: CarCategory,
    val availability: Boolean,
    val timeBlock: List<TimeBlock>,
    val ownerId: Int,
//    val photos: List<String>
)

enum class CarCategory {
    ICE,
    BEV,
    FCEV
}

@Serializable
data class TimeBlock(
    val startTime: Long,
    val endTime: Long
)
