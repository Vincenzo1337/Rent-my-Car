package rent.my.car.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserSignInDto (
    val email: String,
    val password: String
)
