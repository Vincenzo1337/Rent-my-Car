package rent.my.car.dao

import rent.my.car.dto.HomePageCarDTO

interface DAOFacadeCar {
    suspend fun allCars(): List<HomePageCarDTO>

    suspend fun searchCars(search: String): List<HomePageCarDTO>
}