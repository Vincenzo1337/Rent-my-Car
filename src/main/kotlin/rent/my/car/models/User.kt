package rent.my.car.models

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
