package rent.my.car.dao

import rent.my.car.dto.HomePageCarDTO
import rent.my.car.dto.UserDTO
import rent.my.car.models.*

object DaoInMemoryCar : DAOFacadeCar {
    private val users = listOf(
        UserDTO(
            name = "Vincent",
            email = "Vincentman169@gmail.com",
            role = Role.OWNER,
            id = 1,
            drivingBehavior = DrivingBehavior.GOOD
        ),
        UserDTO(
            name = "Kayal",
            email = "Kayal@gmail.com",
            role = Role.RENTER,
            id = 2,
            drivingBehavior = DrivingBehavior.BAD
        ),
        UserDTO(
            name = "Casper",
            email = "Casper@gmail.com",
            role = Role.RENTER,
            id = 3,
            drivingBehavior = DrivingBehavior.GOOD
        )
    )

    // Counter om bij te houden welke gebruiker de volgende is
    private var userCounter = 0

    override suspend fun allCars(): List<HomePageCarDTO> = cars.values.map { car ->
        // Selecteer de gebruiker op basis van de huidige userCounter
        val user = users[userCounter % users.size]

        // Verhoog de counter voor de volgende oproep
        userCounter++

        HomePageCarDTO(
            brand = car.brand,
            type = car.type,
            category = car.category,
            availability = car.availability,
//            timeBlock = car.timeBlock,
//            owner = user
        )
    }

    private val cars = mutableMapOf(
        "BMW" to Car("BWM", "E30", CarCategory.ICE, true),
        "VW" to Car("VW", "Golf", CarCategory.BEV, false),
        "Merrie" to Car("Merrie", "AMG", CarCategory.FCEV, true),
    )

    private data class Car(
        val brand: String,
        val type: String,
        val category: CarCategory,
        val availability: Boolean,
    )

    fun getCarById(id: Int): HomePageCarDTO? {
        val carD = carDetails[id]
        if (carD != null) {
            val userDTO = UserDTO(
                name = carD.user.name,
                email = carD.user.email,
                role = carD.user.role,
                id = carD.user.id,
                drivingBehavior = carD.user.drivingBehavior
            )
            return HomePageCarDTO(
                brand = carD.brand,
                type = carD.type,
                category = carD.category,
                availability = carD.availability,
            )
        }
        return null
    }

    private val carDetails = mutableMapOf(
        1 to CarDetails("BWM", "E30", CarCategory.ICE, UserDatabase.users[0], true),
        2 to CarDetails("VW", "Golf", CarCategory.BEV, UserDatabase.users[1], false),
        3 to CarDetails("Merrie", "AMG", CarCategory.FCEV, UserDatabase.users[2], true),
    )

    private data class CarDetails(
        val brand: String,
        val type: String,
        val category: CarCategory,
        val user: User,
        val availability: Boolean,
    )
}
