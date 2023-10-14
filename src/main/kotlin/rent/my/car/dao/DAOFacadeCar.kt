package rent.my.car.dao

import rent.my.car.dto.CarDTO

interface DAOFacadeCar {
    suspend fun allCars(): List<CarDTO>
}