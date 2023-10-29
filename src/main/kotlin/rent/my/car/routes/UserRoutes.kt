package rent.my.car.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dto.UserDTO
import rent.my.car.dao.DaoInMemoryUser as daoUser

fun Route.userRouting() {
    get("/") {
        call.respondText("Rent my car User API")
    }

    get("/users") {
        call.respond(daoUser.allUsers())
    }

    get("/user/{id}") {
        val userId = call.parameters["id"]?.toInt()

        if (userId != null) {
            print(userId)
            val user = daoUser.getUserById(userId)
            if (user != null) {
                print(user)
                call.respond(user)
            } else {
                call.respondText("User not found", status = HttpStatusCode.NotFound)
            }
        } else {
            call.respondText("Invalid user ID", status = HttpStatusCode.BadRequest)
        }
    }
    post("/users") {
        val userDTO = call.receive<UserDTO>()

        // Voeg de nieuwe gebruiker toe aan de database
        val newUser = daoUser.addUser(userDTO)

        call.respond(HttpStatusCode.Created, "Gebruiker is aangemaakt")
    }

}
