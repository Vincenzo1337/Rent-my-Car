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
        Account("vincent", "test1234", 1, "Vincent", "0612345678", "vincent@gmail.com"),
        Account("kayal", "test1234", 2, "Kayal", "0612345678", "kayal@gmail.com"),
        Account("casper", "test1234", 3,  "Casper", "0612345678", "casper@gmail.com"),
        Account("michael", "test1234", 4,  "Michael", "0612345678", "michael@gmail.com",),
        Account("herman", "test1234", 5,  "Herman", "0612345678", "herman@gmail.com"),
        Account("jasper", "test1234", 6,  "Jasper", "0612345678", "jasper@gmail.com"),
        Account("joost", "test1234", 7, "Joost", "0612345678", "joost@gmail.com"),
        Account("jill", "test1234", 8, "Jill", "0612345678", "jill@gmail.com"),
        Account("kekw", "test1234", 9,  "Kekw", "0612345678", "kekw@gmail.com"),
        Account("jax", "test1234", 10,  "Jax", "0612345678", "jax@gmail.com"),
    )
    var nextUserId = accounts.size + 1 // Begint bij 11
}