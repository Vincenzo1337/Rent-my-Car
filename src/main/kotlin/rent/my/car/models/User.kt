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
    GOOD,
    BAD,
    NONE

}


