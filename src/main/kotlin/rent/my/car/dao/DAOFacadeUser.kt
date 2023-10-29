package rent.my.user.dao

import rent.my.car.dto.UserDTO

interface DAOFacadeUser {
    suspend fun allUsers(): List<UserDTO>
    suspend fun addUser(user: UserDTO): UserDTO
}

