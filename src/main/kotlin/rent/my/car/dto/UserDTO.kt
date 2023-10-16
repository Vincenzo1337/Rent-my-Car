package rent.my.car.dto

import kotlinx.serialization.Serializable
import rent.my.car.models.Role

@Serializable
data class UserDTO(
    val name: String,
    val email: String,
    val role: Role
)

data class DrivingBehaviorDTO(
    val distanceDriven: Double,
    val accelerationOnStart: Double,
    val deceleration: Double
)

data class BonusPointsDTO(
    val points: Int
)


