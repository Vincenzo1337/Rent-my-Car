package rent.my.car.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val email: String,
    val password: String,
    val role: Role
)

enum class Role {
    OWNER,
    RENTER
}

data class RentalAgreement(
    val renter: User,
    val rentalCar: RentalCar,
    val selectedTimeBlock: TimeBlock,
    val bonusPoints: Int
) {
    // fun requestRoute() {
    //     // Implement logic to request a route
    // }

    // fun awardBonusPoints() {
    //     // Implement logic to award bonus points
    // }
}

data class BonusPoints(
    val points: Int
) {
    // fun awardPoints() {
    //     // Implement logic to award bonus points
    // }
}

data class DrivingBehavior(
    val distanceDriven: Double,
    val accelerationOnStart: Double,
    val deceleration: Double
)

object UserDatabase {
    val users: List<User> = listOf(
        User("User1", "user1@example.com", "password1", Role.OWNER),
        User("User2", "user2@example.com", "password2", Role.RENTER),
        User("User3", "user3@example.com", "password3", Role.OWNER)
    )
}
