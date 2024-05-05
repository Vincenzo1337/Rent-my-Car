package rent.my.car.dao

import rent.my.car.dto.HomePageCarDTO
import rent.my.car.models.Account

interface DAOFacadeAccount {
    suspend fun login(username:String, password:String): Boolean
    suspend fun register(account: Account): Boolean
    suspend fun getAccounts(): List<Account>
    suspend fun updateAccount(updatedAccount: Account): Boolean
}
