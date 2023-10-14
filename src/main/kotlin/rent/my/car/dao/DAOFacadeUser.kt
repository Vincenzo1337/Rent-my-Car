package rent.my.car.dao

import rent.my.car.dto.UserProfileDto
import rent.my.car.dto.UserRegisterDto
import rent.my.car.dto.UserSignInDto
import rent.my.car.dto.UserUpdateDto

interface DAOFacadeUser {
    suspend fun registerUser(user: UserRegisterDto): Boolean
    suspend fun allUsers(): List<UserRegisterDto>
    suspend fun signInUser(user: UserSignInDto): UserRegisterDto?

    // stage 3/5
    suspend fun updateUser(userWithProfile: UserUpdateDto): Boolean
    suspend fun findUserWithEmail(email: String): UserProfileDto?
    suspend fun deleteUserWithEmail(email: String): Boolean

    suspend fun allUserProfiles(): List<UserProfileDto>
}