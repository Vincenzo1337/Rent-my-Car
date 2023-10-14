package rent.my.car.dao

import rent.my.car.dto.CarDTO
import rent.my.car.dto.CarRentalConditions
import rent.my.car.models.CarCategory

object DaoInMemoryCar : DAOFacadeCar {
    override suspend fun allCars(): List<CarDTO> = cars.values.map { car ->
        CarDTO(
            brand = car.brand,
            type = car.type,
            category = car.category,
//            rentalConditions = CarRentalConditions())
        )
    }

//    TODO aanpassen naar get all cars details
//    override suspend fun allUserProfiles(): List<UserProfileDto> = users.values.map { it.toUserProfileDto() }

    private val cars = mutableMapOf<String, DaoInMemoryCar.Car>(
        "BMW" to DaoInMemoryCar.Car("BWM", "E30", CarCategory.ICE),
        "VW" to DaoInMemoryCar.Car("VW", "Golf", CarCategory.BEV),
        "Merrie" to DaoInMemoryCar.Car("Merrie", "AMG", CarCategory.FCEV),
    )

    private data class Car(
        val brand: String,
        val type: String,
        val category: CarCategory,
    )
}
