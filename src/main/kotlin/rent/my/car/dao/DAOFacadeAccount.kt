package rent.my.car.dao

import rent.my.car.dto.HomePageCarDTO

interface DAOFacadeAccount {
    suspend fun login(username:String, password:String): Boolean
}