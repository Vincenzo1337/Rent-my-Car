package rent.my.car.models

import kotlinx.serialization.Serializable



@Serializable
data class User(
    val name: String,
    val email: String,
    val password: String,
    val role: Role,
    val id:  Int,
    val drivingBehavior: DrivingBehavior,
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

//data class DrivingBehavior(
//    val distanceDriven: Double,
//    val accelerationOnStart: Double,
//    val deceleration: Double
//)
enum class DrivingBehavior{
    good,
    bad,
    none

}

object UserDatabase {
    val users: List<User> = listOf(
        User("User1", "user1@example.com", "password1", Role.OWNER, 0, DrivingBehavior.none),
        User("User2", "user2@example.com", "password2", Role.RENTER, 2, DrivingBehavior.bad),
        User("User3", "user3@example.com", "password3", Role.OWNER, 3, DrivingBehavior.good)
    )
}
