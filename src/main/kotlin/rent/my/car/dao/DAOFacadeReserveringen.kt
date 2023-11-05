package rent.my.car.dao

import rent.my.car.dto.ReserveringenDTO

interface DAOFacadeReserveringen {
    suspend fun allReserveringen(): List<ReserveringenDTO>
}