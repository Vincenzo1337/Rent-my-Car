package rent.my.car.plugins

import rent.my.car.routes.userRouting
import rent.my.car.routes.carRouting
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(StatusPages) {

        exception<AlreadyExistsException> { call, cause ->
            call.respond(
                HttpStatusCode.Forbidden,
                hashMapOf("status" to "User already exists"),
            )
        }

//melding als gebruiker al bestaat, retourtneert 403 error. 

        exception<AccessDeniedException> { call, _ ->
            call.respond(
                HttpStatusCode.Forbidden,
                hashMapOf("status" to "Access denied"),
            )
        }

//toegang wordt geweigerd tot bepaalde delen van de applicatie.

        exception<InvalidUpdateMeException> { call, _ ->
            call.respond(
                HttpStatusCode.BadRequest,
                hashMapOf("status" to "cannot update user with different email"),
            )
        }

//geeft foutmelding terug bij bewerken van gebruiker niet toegestaan 

        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }

    routing {
        carRouting()
        userRouting()
    }
}


class WrongIdFormatException : Exception("id parameter is not an integer:")
class WrongIdRangeException : Exception("id is an integer but outside the range")
class AlreadyExistsException(email: String) : Throwable("user with $email already exists")
class WrongSigninException : Throwable("wrong signing in credentials")

// for stage 3/5
class InvalidUpdateMeException : Throwable()


class AccessDeniedException : Throwable()
