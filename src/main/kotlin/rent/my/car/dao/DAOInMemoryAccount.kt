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

    override suspend fun register(account: Account): Boolean {
        return if (AccountDatabase.accounts.none { it.userName == account.userName }) {
            val newAccount = Account(
                userName = account.userName,
                password = account.password,
                userId = AccountDatabase.nextUserId++,
                phone = account.phone,
                email = account.email
            )
            AccountDatabase.accounts.add(newAccount)
            true
        } else {
            false
        }
    }

    override suspend fun getAccounts(): List<Account> {
        return AccountDatabase.accounts.toList()
    }

    override suspend fun updateAccount(updatedAccount: Account): Boolean {
        val accountIndex = AccountDatabase.accounts.indexOfFirst { it.userId == updatedAccount.userId }
        return if (accountIndex != -1) {
            AccountDatabase.accounts[accountIndex] = updatedAccount
            true
        } else {
            false
        }
    }
}

object AccountDatabase {
    val accounts = mutableListOf(
        Account("vincent", "test1234", 1,  "0612345678", "vincent@gmail.com"),
        Account("kayal", "test1234", 2,  "0612345678", "kayal@gmail.com"),
        Account("casper", "test1234", 3,   "0612345678", "casper@gmail.com"),
        Account("michael", "test1234", 4,  "0612345678", "michael@gmail.com",),
        Account("herman", "test1234", 5,  "0612345678", "herman@gmail.com"),
        Account("jasper", "test1234", 6,  "0612345678", "jasper@gmail.com"),
        Account("joost", "test1234", 7, "0612345678", "joost@gmail.com"),
        Account("jill", "test1234", 8, "0612345678", "jill@gmail.com"),
        Account("kekw", "test1234", 9, "0612345678", "kekw@gmail.com"),
        Account("jax", "test1234", 10, "0612345678", "jax@gmail.com"),
    )
    var nextUserId = accounts.size + 1
}