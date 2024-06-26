package rent.my.car.dto

import kotlinx.serialization.Serializable
import rent.my.car.models.CarCategory
import rent.my.car.models.Location
import rent.my.car.models.TimeBlock

@Serializable
data class HomePageCarDTO(
    val id: Int,
    val brand: String,
    val type: String,
    val category: CarCategory,
    val availability: Boolean,
    val timeBlock: List<TimeBlock>,
    val description: String,
    val ownerId: Int,
    val owner: UserDTO?,
    val location: Location? = null,
    val isNew: Boolean = false
)