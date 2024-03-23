package rent.my.car.dao

import rent.my.car.dto.UserDTO
import rent.my.car.models.DrivingBehavior
import rent.my.car.models.Role
import rent.my.car.models.User
import rent.my.user.dao.DAOFacadeUser

object DaoInMemoryUser : DAOFacadeUser {

    override suspend fun allUsers(): List<UserDTO> = UserDatabase.users.values.map { user ->
        UserDTO(
            name = user.name,
            email = user.email,
            role = user.role,
            id = user.id,
            drivingBehavior = user.drivingBehavior
        )
    }

    override suspend fun addUser(user: UserDTO): UserDTO {
        val newUserId = if (UserDatabase.users.isEmpty()) 0 else UserDatabase.users.size + 1
        val newUser = user.copy(id = newUserId) // Assign new ID to the user
        UserDatabase.users[newUserId] =
            User(
                name = user.name,
                email = user.email,
                password = "",
                role = user.role,
                id = newUser.id,
                drivingBehavior = user.drivingBehavior
            )

        return newUser
    }


    fun getUserById(id: Int): UserDTO? {
        val userD = UserDatabase.users[id]
        if (userD != null) {
            return UserDTO(
                name = userD.name,
                email = userD.email,
                role = userD.role,
                id = userD.id,
                drivingBehavior = userD.drivingBehavior
            )
        }
        return null
    }
}

object UserDatabase {
    val users = mutableMapOf(
        1 to User("Vincent", "Vincentman169@gmail.com", "password1", Role.OWNER, 1, DrivingBehavior.GOOD),
        2 to User("Kayal", "Kayal@gmail.com", "password2", Role.RENTER, 2, DrivingBehavior.BAD),
        3 to User("Casper", "Casper@gmail.com", "password3", Role.OWNER, 3, DrivingBehavior.NONE)
    )
}