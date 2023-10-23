package rent.my.car.dao

import rent.my.car.dto.UserDTO
import rent.my.car.models.UserDatabase
import rent.my.user.dao.DAOFacadeUser

object DaoInMemoryUser : DAOFacadeUser {

    override suspend fun allUsers(): List<UserDTO> = UserDatabase.users.map { user ->
        UserDTO(
            name = user.name,
            email = user.email,
            role = user.role,
            id = user.id,
            drivingBehavior = user.drivingBehavior
        )
    }
}

fun getUsersByIds(ids: List<Int>): List<UserDTO> {
    return ids.mapNotNull { id ->
        val user = UserDatabase.users.getOrNull(id - 1) // -1 omdat de ID's in de lijst met gebruikers bij 1 beginnen
        user?.let {
            UserDTO(
                name = user.name,
                email = user.email,
                role = user.role,
                id = user.id,
                drivingBehavior = user.drivingBehavior
            )
        }
    }
}


fun getUserById(id: Int): UserDTO? {
    val user = UserDatabase.users.getOrNull(id - 1) // -1 omdat de ID's in de lijst met gebruikers bij 1 beginnen
    return user?.let {
        UserDTO(
            name = user.name,
            email = user.email,
            role = user.role,
            id = user.id,
            drivingBehavior = user.drivingBehavior
        )
    }
}



