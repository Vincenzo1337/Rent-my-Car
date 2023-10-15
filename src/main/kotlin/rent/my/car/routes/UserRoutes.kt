package rent.my.car.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dao.DaoInMemoryUser as dao

fun Route.userRouting() {
    get("/users") {
        call.respond(dao.allUsers())
    }

}
