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
        Account("kayal", "test1234", 2),
        Account("casper", "test1234", 3),
        Account("michael", "test1234", 4),
        Account("herman", "test1234", 5),
        Account("jasper", "test1234", 6),
        Account("joost", "test1234", 7),
        Account("jill", "test1234", 8),
        Account("kekw", "test1234", 9),
        Account("jax", "test1234", 10),
    )
}