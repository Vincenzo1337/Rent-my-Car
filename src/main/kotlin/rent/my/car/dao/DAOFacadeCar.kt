package rent.my.car.dao

import rent.my.car.dto.HomePageCarDTO
import rent.my.car.models.Car

interface DAOFacadeCar {
    suspend fun allCars(): List<HomePageCarDTO>

    suspend fun searchCars(search: String): List<HomePageCarDTO>

    suspend fun createCar(car: Car): Car
}