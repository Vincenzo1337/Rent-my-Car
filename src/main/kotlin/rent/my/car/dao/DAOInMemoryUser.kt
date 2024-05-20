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
        1 to User("Emma", "Emma@gmail.com", "password1", Role.OWNER, 1, DrivingBehavior.GOOD),
        2 to User("Lucas", "Lucas@gmail.com", "password2", Role.OWNER, 2, DrivingBehavior.BAD),
        3 to User("Sophie", "Sophie@gmail.com", "password3", Role.OWNER, 3, DrivingBehavior.NONE),
        4 to User("Daan", "Daan@gmail.com", "password4", Role.OWNER, 4, DrivingBehavior.GOOD),
        5 to User("Julia", "Julia@gmail.com", "password5", Role.OWNER, 5, DrivingBehavior.BAD),
        6 to User("Max", "Max@gmail.com", "password6", Role.OWNER, 6, DrivingBehavior.NONE),
        7 to User("Anna", "Anna@gmail.com", "password7", Role.OWNER, 7, DrivingBehavior.GOOD),
        8 to User("Finn", "Finn@gmail.com", "password8", Role.OWNER, 8, DrivingBehavior.BAD),
        9 to User("Sara", "Sara@gmail.com", "password9", Role.OWNER, 9, DrivingBehavior.NONE),
        10 to User("Levi", "Levi@gmail.com", "password10", Role.OWNER, 10, DrivingBehavior.GOOD)
    )
}