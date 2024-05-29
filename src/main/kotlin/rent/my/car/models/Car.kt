package rent.my.car.models

import kotlinx.serialization.Serializable

@Serializable
data class Car(
    val id: Int? = null,
    val brand: String,
    val type: String,
    val category: CarCategory,
    val availability: Boolean,
    val timeBlock: List<TimeBlock>,
    val description: String,
    val ownerId: Int,
    val owner: User? = null,
    val location: Location? = null
)

@Serializable
data class Location(val latitude: Double, val longitude: Double)


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
