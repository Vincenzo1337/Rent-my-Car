package rent.my.car.dao

import rent.my.car.dto.HomePageCarDTO
import rent.my.car.dto.UserDTO
import rent.my.car.models.*

object DaoInMemoryCar : DAOFacadeCar {

    override suspend fun allCars(): List<HomePageCarDTO> = CarDatabase.cars.map { (id, car) ->
        HomePageCarDTO(
            id = id,
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
        CarDatabase.cars.filter { keyValue -> keyValue.value.brand.contains(search) || keyValue.value.type.contains(search) }.map { (id, car) ->
            HomePageCarDTO(
                id = id,
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
                id = id,
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
        2 to Car("Volkswagen", "Golf", CarCategory.BEV, false, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[2]!!.id),
        3 to Car("Mercedes", "AMG", CarCategory.FCEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[3]!!.id),
        4 to Car("Volvo", "V60", CarCategory.BEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[4]!!.id),
        5 to Car("Toyota", "Corolla", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[5]!!.id),
        6 to Car("Ford", "Mustang", CarCategory.BEV, false, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[6]!!.id),
        7 to Car("Honda", "Civic", CarCategory.FCEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[7]!!.id),
        8 to Car("Nissan", "Altima", CarCategory.BEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[8]!!.id),
        9 to Car("Chevrolet", "Silverado", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), UserDatabase.users[9]!!.id)
    )
}
