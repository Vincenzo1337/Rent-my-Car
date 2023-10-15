package rent.my.car.dao

import rent.my.car.dto.CarDTO
import rent.my.car.dto.UserDTO
import rent.my.car.models.CarCategory
import rent.my.car.models.Role
import rent.my.car.models.User
import rent.my.car.models.UserDatabase

object DaoInMemoryCar : DAOFacadeCar {

    // All cars without details and users
    override suspend fun allCars(): List<CarDTO> = cars.values.map { car ->
        CarDTO(
            brand = car.brand,
            type = car.type,
            category = car.category,
//            rentalConditions = CarRentalConditions())
//            Create own user like line: 25 of 53, in de DAOInMemoryUser
//            Of bij de UserDTO meteen een aantaal users defineren
            owner = UserDTO(name = "Vincent", email = "Vincentman169@gmail.com", role = Role.OWNER)

        )
    }

    private val cars = mutableMapOf(
        "BMW" to Car("BWM", "E30", CarCategory.ICE),
        "VW" to Car("VW", "Golf", CarCategory.BEV),
        "Merrie" to Car("Merrie", "AMG", CarCategory.FCEV),
    )

    private data class Car(
        val brand: String,
        val type: String,
        val category: CarCategory,
    )

    fun getCarById(id: Int): CarDTO? {
        val carD = carDetails[id]
        if (carD != null) {
            val userDTO = UserDTO(
                name = carD.user.name,
                email = carD.user.email,
                role = carD.user.role
            )
            return CarDTO(
                brand = carD.brand,
                type = carD.type,
                category = carD.category,
                owner = userDTO
            )
        }
        return null
    }

    private val carDetails = mutableMapOf(
        1 to CarDetails("BWM", "E30", CarCategory.ICE, UserDatabase.users[0]),
        2 to CarDetails("VW", "Golf", CarCategory.BEV, UserDatabase.users[1]),
        3 to CarDetails("Merrie", "AMG", CarCategory.FCEV, UserDatabase.users[2]),
    )

    private data class CarDetails(
        val brand: String,
        val type: String,
        val category: CarCategory,
        val user: User,
    )
}
