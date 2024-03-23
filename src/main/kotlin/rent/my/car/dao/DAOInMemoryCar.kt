package rent.my.car.dao

import rent.my.car.dto.HomePageCarDTO
import rent.my.car.dto.UserDTO
import rent.my.car.models.*

object DaoInMemoryCar : DAOFacadeCar {

    override suspend fun allCars(): List<HomePageCarDTO> = CarDatabase.cars.values.map { car ->
        HomePageCarDTO(
            brand = car.brand,
            type = car.type,
            category = car.category,
            availability = car.availability,
            timeBlock = car.timeBlock,
            ownerId = car.ownerId,
            owner = DaoInMemoryUser.getUserById(car.ownerId)
        )
    }

    override suspend fun searchCars(search: String): List<HomePageCarDTO> =
        CarDatabase.cars.values.filter { car -> car.brand.contains(search) || car.type.contains(search) }.map { car ->
            HomePageCarDTO(
                brand = car.brand,
                type = car.type,
                category = car.category,
                availability = car.availability,
                timeBlock = car.timeBlock,
                ownerId = car.ownerId,
                owner = DaoInMemoryUser.getUserById(car.ownerId)
            )
        }

    fun getCarById(id: Int): HomePageCarDTO? {
        val car = CarDatabase.cars[id]
        if (car != null) {
            return HomePageCarDTO(
                brand = car.brand,
                type = car.type,
                category = car.category,
                availability = car.availability,
                timeBlock = car.timeBlock,
                ownerId = car.ownerId,
                owner = DaoInMemoryUser.getUserById(car.ownerId)
            )
        }
        return null
    }
}

object CarDatabase {
    val cars = mutableMapOf(
        1 to Car("BMW", "E30", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[1]!!.id),
        2 to Car("VW", "Golf", CarCategory.BEV, false, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[2]!!.id),
        3 to Car("Merrie", "AMG", CarCategory.FCEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[3]!!.id),
        4 to Car("Volvo", "V60", CarCategory.BEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[1]!!.id),
    )
}
