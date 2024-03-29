package rent.my.car.models

import kotlinx.serialization.Serializable

@Serializable
data class Account (
    val userName: String,
    val password: String,
    val userId: Int
)