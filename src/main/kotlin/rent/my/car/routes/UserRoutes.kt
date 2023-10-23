package rent.my.car.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dao.DaoInMemoryUser as daoUser

fun Route.userRouting() {
    get("/") {
        call.respondText("Rent my car User API")
    }

    get("/users") {
        call.respond(daoUser.allUsers())
    }
}
//    get("/user/{id}") {
//        val userId = call.parameters["id"]?.toInt()
//
//        if (userId != null) {
//            val user = daoUser.getUserById(userId)
//            if (user != null) {
//                call.respond(user)
//            } else {
//                call.respondText("User not found", status = HttpStatusCode.NotFound)
//            }
//        } else {
//            call.respondText("Invalid user ID", status = HttpStatusCode.BadRequest)
//        }
//    }
//}
