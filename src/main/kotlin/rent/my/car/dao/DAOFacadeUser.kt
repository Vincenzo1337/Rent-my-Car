package rent.my.user.dao

import rent.my.car.dto.UserDTO

interface DAOFacadeUser {
    suspend fun allUsers(): List<UserDTO>
}

//een asynchrone functie, wat betekent dat deze functie niet direct wacht op een resultaat maar kan worden opgeschort en later hervat.
