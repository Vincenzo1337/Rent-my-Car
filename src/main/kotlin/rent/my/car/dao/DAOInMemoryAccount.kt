package rent.my.car.dao

import rent.my.car.dto.UserDTO
import rent.my.car.models.Account
import rent.my.car.models.DrivingBehavior
import rent.my.car.models.Role
import rent.my.car.models.User
import rent.my.user.dao.DAOFacadeUser

object DaoInMemoryAccount : DAOFacadeAccount {

    override suspend fun login(username: String, password: String): Boolean {
        return AccountDatabase.accounts.any{account: Account -> account.userName == username && account.password == password }
    }
}

object AccountDatabase {
    val accounts = mutableListOf(
        Account("vincent", "test1234", 1),
    )
}